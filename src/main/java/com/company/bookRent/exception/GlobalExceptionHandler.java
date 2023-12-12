package com.company.bookRent.exception;

import com.company.bookRent.globalResponse.ResponseDTO;
import com.company.bookRent.globalResponse.ResponseType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler({CannotRentalException.class, IllegalAccessTokenException.class, IllegalRentalException.class})
    public ResponseDTO<?> illegalArgumentException(Exception e) {
        log.info("e: {}", e.getMessage());

        return ResponseDTO.exception(ResponseType.BAD_REQUEST, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler({BookNotFoundException.class, UserNotFoundException.class})
    public ResponseDTO<?> notFoundException(Exception e) {
        log.info("e: {}", e.getMessage());

        return ResponseDTO.exception(ResponseType.NOT_FOUND, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler({DuplicateUserException.class})
    public ResponseDTO<?> duplicateException(Exception e) {
        log.info("e: {}", e.getMessage());

        return ResponseDTO.exception(ResponseType.BAD_REQUEST, e.getMessage());
    }
}
