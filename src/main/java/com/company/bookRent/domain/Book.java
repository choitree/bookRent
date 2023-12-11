package com.company.bookRent.domain;

import com.company.bookRent.controller.dto.BookRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String isbn;

    private Boolean isRental;

    @OneToMany
    @JoinColumn(name = "book_id")
    private List<Rental> rentals = new ArrayList<>();


    public static Book create(BookRequestDTO bookRequestDTO) {
        return Book.builder()
                .name(bookRequestDTO.getName())
                .isbn(bookRequestDTO.getIsbn())
                .isRental(Boolean.FALSE)
                .build();
    }

    public void update(BookRequestDTO bookRequestDTO) {
        if(bookRequestDTO.getName() != null) {
            this.name = bookRequestDTO.getName();
        }
        if(bookRequestDTO.getIsbn() != null) {
            this.isbn = bookRequestDTO.getIsbn();
        }
    }

    public void rentBook() {
        this.isRental = Boolean.TRUE;
    }

    public void returnBook() {
        this.isRental = Boolean.FALSE;
    }
}
