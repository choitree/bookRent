package com.company.bookRent.controller.dto;

import com.company.bookRent.domain.Book;
import com.company.bookRent.domain.Rental;
import com.company.bookRent.domain.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class RentalResponseDTO {

    private Long id;
    private LocalDateTime rentalDate;
    private LocalDateTime returnDate;

    private String loginId;

    private Long bookId;
    private String bookName;
    private boolean isRental;

    public static RentalResponseDTO of(Rental rental) {
        return RentalResponseDTO.builder()
                .id(rental.getId())
                .rentalDate(rental.getRentalDate())
                .returnDate(rental.getReturnDate())
                .loginId(rental.getUser().getLoginId())
                .bookId(rental.getBook().getId())
                .bookName(rental.getBook().getName())
                .isRental(rental.getBook().getIsRental())
                .build();
    }
}
