package com.company.bookRent.service;

import com.company.bookRent.controller.dto.RentalResponseDTO;
import com.company.bookRent.domain.Book;
import com.company.bookRent.domain.Rental;
import com.company.bookRent.domain.User;
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

    public void rentBook(Long bookId, String userId) {
        Book book = bookService.find(bookId);
        book.rentBook();
        bookService.update(book);
        User user = userService.find(userId);
        Rental rental = Rental.rentBook(book, user);
        rentalRepository.save(rental);
    }

    public void returnBook(Long bookId, String userId) {
        Book book = bookService.find(bookId);
        book.returnBook();
        bookService.update(book);
        User user = userService.find(userId);
        Rental rental = rentalRepository.findFirstByUserAndBookOrderByRentalDateDesc(user, book);
        rental.returnBook();
        rentalRepository.save(rental);
    }
}
