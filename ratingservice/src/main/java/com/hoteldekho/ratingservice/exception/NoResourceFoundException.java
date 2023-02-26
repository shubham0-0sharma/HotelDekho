package com.hoteldekho.ratingservice.exception;

public class NoResourceFoundException extends RuntimeException{
    public NoResourceFoundException(){
        super("No Resource found");
    }
    public  NoResourceFoundException(String msg){

    }
}
