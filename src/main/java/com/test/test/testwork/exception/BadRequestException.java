package com.test.test.testwork.exception;

public class BadRequestException extends RuntimeException {
    private final String message;

    public BadRequestException(String message) {
        super(message);
        this.message = message;
    }

    public static BadRequestException dataNotFound(){
        return new BadRequestException("data_not.found");
    }

}
