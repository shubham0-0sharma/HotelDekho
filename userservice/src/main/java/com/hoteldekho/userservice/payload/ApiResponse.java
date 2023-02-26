package com.hoteldekho.userservice.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

//the object will be created and then will be serialized to json using Response body
//POJO class
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//to build the object in ease
@Builder
public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus httpStatus;
}
