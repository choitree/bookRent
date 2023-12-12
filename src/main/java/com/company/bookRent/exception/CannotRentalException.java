package com.company.bookRent.exception;

public class CannotRentalException extends RuntimeException {

    public CannotRentalException() {
        super("다른 회원이 이미 책을 빌린 상태입니다. 대여 불가능합니다.");
    }
}
