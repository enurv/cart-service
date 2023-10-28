package com.example.cartservice.exception;

import com.example.cartservice.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MaximumItemLimitExceededException.class)
    public ResponseEntity<ResponseDTO> handleBadRequestException(BadRequestException exception) {
        ResponseDTO errorResponse = new ResponseDTO(false, exception.getMessage());
        return new ResponseEntity<ResponseDTO>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO> handleOtherExceptions(Exception ex) {
        ResponseDTO errorResponse = new ResponseDTO(false, "An unexpected error occurred.");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
