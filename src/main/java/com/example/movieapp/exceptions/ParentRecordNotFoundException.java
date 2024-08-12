package com.example.movieapp.exceptions;

import com.example.movieapp.enums.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ParentRecordNotFoundException extends RuntimeException {

    private final ErrorCode errorCode;

    public ParentRecordNotFoundException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
