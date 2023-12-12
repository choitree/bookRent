package com.company.bookRent.controller.dto;

import com.company.bookRent.domain.Book;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BookResponseDTO {

    private long id;
    private String name;
    private String isbn;

    public static BookResponseDTO of(Book book) {
        return BookResponseDTO.builder()
                .id(book.getId())
                .name(book.getName())
                .isbn(book.getIsbn())
                .build();
    }
}
