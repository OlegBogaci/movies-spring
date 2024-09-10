package com.example.movieapp.advice;

import com.example.movieapp.dto.ErrorResponse;
import com.example.movieapp.exceptions.ParentRecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DefaultAdvice {

    @ExceptionHandler(ParentRecordNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResponseStatusException(ParentRecordNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
