package com.company.bookRent.exception;

public class IllegalAccessTokenException extends RuntimeException {

    public IllegalAccessTokenException() {
        super("유효하지 않은 AccessToken입니다.");
    }
}
