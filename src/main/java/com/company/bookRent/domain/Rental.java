package com.company.bookRent.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rental {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime rentalDate;

    @Nullable
    private LocalDateTime returnDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public static Rental rentBook(Book book, User user) {
        return Rental.builder()
                .book(book)
                .user(user)
                .rentalDate(LocalDateTime.now())
                .build();
    }

    public void returnBook() {
        this.returnDate = LocalDateTime.now();
    }
}
