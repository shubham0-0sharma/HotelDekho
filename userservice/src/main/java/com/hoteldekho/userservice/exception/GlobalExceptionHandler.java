package com.hoteldekho.userservice.exception;

import com.hoteldekho.userservice.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoResourceFoundException.class)
public ResponseEntity<ApiResponse> NoResourceFoundExceptionHandler(NoResourceFoundException ex){
    String message = ex.getMessage();
    ApiResponse response = ApiResponse.builder().message(message).success(true).httpStatus(HttpStatus.NOT_FOUND).build();
    return new ResponseEntity<>(response , HttpStatus.NOT_FOUND);


}
}
