package com.hoteldekho.userservice.exception;

public class NoResourceFoundException extends  RuntimeException{
    public NoResourceFoundException(){
        super("Resource not Found!");
    }
    public NoResourceFoundException(String message){
        super(message);
    }
}
