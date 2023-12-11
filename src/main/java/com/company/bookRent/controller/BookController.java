package com.company.bookRent.controller;

import com.company.bookRent.controller.dto.BookRequestDTO;
import com.company.bookRent.domain.Book;
import com.company.bookRent.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class BookController {

    private final BookService bookService;

    @PostMapping("/book")
    public Book create(@RequestBody BookRequestDTO bookRequestDTO) {
        return bookService.save(bookRequestDTO);
    }

    @PutMapping("/book")
    public Book update(@PathVariable Long id, @RequestBody BookRequestDTO bookRequestDTO) {
        return bookService.update(id, bookRequestDTO);
    }

}
