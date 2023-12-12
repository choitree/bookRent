package com.company.bookRent.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException() {
        super("해당하는 회원을 찾을 수 없습니다.");
    }
}
