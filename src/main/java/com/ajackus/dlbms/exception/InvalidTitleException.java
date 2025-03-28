package com.ajackus.dlbms.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InvalidTitleException extends RuntimeException {
    private String message;
}
