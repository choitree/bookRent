package com.company.bookRent.service;

import com.company.bookRent.controller.dto.RentalResponseDTO;
import com.company.bookRent.domain.Book;
import com.company.bookRent.domain.Rental;
import com.company.bookRent.domain.User;
import com.company.bookRent.exception.CannotRentalException;
import com.company.bookRent.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RentalService {

    private final RentalRepository rentalRepository;
    private final BookService bookService;
    private final UserService userService;

    public List<RentalResponseDTO> getRentalList(Long bookId) {
        Book book = bookService.find(bookId);
        return rentalRepository.findAllByBook(book).stream()
                .map(rental -> RentalResponseDTO.of(rental))
                .toList();
    }

    public RentalResponseDTO rentBook(Long bookId, String userId) {
        Book book = bookService.find(bookId);
        if(book.getIsRental()) {
            throw new CannotRentalException();
        }
        book.rentBook();
        bookService.update(book);
        User user = userService.find(userId);
        Rental rental = Rental.rentBook(book, user);
        Rental saveRental = rentalRepository.save(rental);
        return RentalResponseDTO.of(saveRental);
    }

    public RentalResponseDTO returnBook(Long bookId, String userId) {
        Book book = bookService.find(bookId);
        book.returnBook();
        bookService.update(book);
        User user = userService.find(userId);
        Rental rental = rentalRepository.findFirstByUserAndBookOrderByRentalDateDesc(user, book);
        rental.returnBook();
        Rental saveRental = rentalRepository.save(rental);
        return RentalResponseDTO.of(saveRental);
    }
}
