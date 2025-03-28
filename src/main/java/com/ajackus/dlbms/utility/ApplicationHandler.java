package com.ajackus.dlbms.utility;

import com.ajackus.dlbms.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationHandler {

    @ExceptionHandler(
            {
                    DuplicateIdFoundException.class,
                    BookNotFoundByIdException.class,
                    BookNotFoundByTitle.class,
                    Exception.class
            }
    )
    public ResponseEntity<ErrorStructure> handleExceptions(RuntimeException ex) {
        ErrorStructure errorStructure = new ErrorStructure();
        errorStructure.setError(ex.getMessage());
        return new ResponseEntity<>(errorStructure, HttpStatus.BAD_REQUEST);
    }
}
