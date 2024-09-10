package com.example.movieapp.dto;

import com.example.movieapp.enums.ErrorCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

    private ErrorCode errorCode;
    private String errorMessage;

    public ErrorResponse(ErrorCode errorCode, String errorMessage) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
}