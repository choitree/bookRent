package com.company.bookRent.service;

import com.company.bookRent.controller.dto.BookRequestDTO;
import com.company.bookRent.domain.Book;
import com.company.bookRent.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public Book save(BookRequestDTO bookRequestDTO){
        Book book = Book.create(bookRequestDTO);
        return bookRepository.save(book);
    }

    public Book update(Long id, BookRequestDTO bookRequestDTO) {
        Book book = find(id);
        book.update(bookRequestDTO);
        return bookRepository.save(book);
    }

    public Book find(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
    }

    public Book update(Book book) {
        return bookRepository.save(book);
    }
}
