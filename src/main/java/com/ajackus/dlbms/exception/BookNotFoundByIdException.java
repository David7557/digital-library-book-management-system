package com.ajackus.dlbms.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class BookNotFoundByIdException extends RuntimeException{
    private String message;
}
