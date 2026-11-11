package com.university.lab06.exceptions;

public class InvalidArticleDataException extends RuntimeException {
    
    public InvalidArticleDataException(String message) {
        super(message);
    }
    
    public InvalidArticleDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
