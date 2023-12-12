package com.company.bookRent.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException() {
        super("해당하는 책을 찾을 수 없습니다.");
    }
}
