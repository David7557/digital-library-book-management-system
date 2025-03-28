package com.ajackus.dlbms.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InvalidAuthorException extends RuntimeException {
    private String message;
}
