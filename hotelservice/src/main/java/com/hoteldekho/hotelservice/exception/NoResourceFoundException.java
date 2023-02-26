package com.hoteldekho.hotelservice.exception;

public class NoResourceFoundException extends RuntimeException {
    public NoResourceFoundException(){
        super("Resource not found");
    }
    public NoResourceFoundException(String msg) {
        super(msg);
    }
}
