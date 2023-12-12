package com.company.bookRent.exception;

public class DuplicateUserException extends RuntimeException {

    public DuplicateUserException() {
        super("이미 가입된 회원입니다.");
    }
}
