package com.ajackus.dlbms.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookNotFoundByTitle extends RuntimeException{
    private String message;
}
