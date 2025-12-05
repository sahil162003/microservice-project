package com.tp.exception;

import com.tp.dto.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice

public class GlobalException {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDto> UserAlreadyExists(RuntimeException exception, WebRequest webRequest){

        ExceptionResponseDto exceptionResponseDto =new ExceptionResponseDto(
                webRequest.getDescription(true),
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now());

        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.BAD_REQUEST);
    }

}
