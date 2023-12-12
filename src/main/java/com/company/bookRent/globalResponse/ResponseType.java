package com.company.bookRent.globalResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ResponseType {
    SUCCESS(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase()),
    CREATED(HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase()),
    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()),
    NOT_FOUND(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase());

    Integer code;
    String message;
}
