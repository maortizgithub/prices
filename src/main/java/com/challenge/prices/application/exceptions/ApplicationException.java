package com.challenge.prices.application.exceptions;

import org.springframework.http.HttpStatus;

public class ApplicationException extends Exception {

    private final HttpStatus statusCode;
    private final ErrorDTO errorDto;

    public ApplicationException(ErrorDTO error, HttpStatus statusCode) {
        super(error.getMessage());
        this.errorDto = error;
        this.statusCode = statusCode;
    }

    public ErrorDTO getErrorDto() {
        return errorDto;
    }


    public HttpStatus getStatus() {
        return this.statusCode;
    }
}

