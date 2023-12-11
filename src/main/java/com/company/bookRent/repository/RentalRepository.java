package com.company.bookRent.repository;

import com.company.bookRent.domain.Book;
import com.company.bookRent.domain.Rental;
import com.company.bookRent.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

    List<Rental> findAllByBook(Book book);

    Rental findFirstByUserAndBookOrderByRentalDateDesc(User user, Book book);
}
