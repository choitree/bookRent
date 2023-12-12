package com.company.bookRent.controller;

import com.company.bookRent.controller.dto.BookRequestDTO;
import com.company.bookRent.controller.dto.BookResponseDTO;
import com.company.bookRent.domain.Book;
import com.company.bookRent.globalResponse.ResponseDTO;
import com.company.bookRent.globalResponse.ResponseType;
import com.company.bookRent.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BookController {

    private final BookService bookService;

    @PostMapping("/book")
    public ResponseDTO<BookResponseDTO> create(@RequestBody BookRequestDTO bookRequestDTO) {
        Book book = bookService.save(bookRequestDTO);
        BookResponseDTO response = BookResponseDTO.of(book);
        return ResponseDTO.from(ResponseType.SUCCESS, response);
    }

    @PutMapping("/book")
    public ResponseDTO<BookResponseDTO> update(@RequestParam Long id, @RequestBody BookRequestDTO bookRequestDTO) {
        Book book = bookService.update(id, bookRequestDTO);
        BookResponseDTO response = BookResponseDTO.of(book);
        return ResponseDTO.from(ResponseType.SUCCESS, response);
    }

}
