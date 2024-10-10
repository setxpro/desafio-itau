package com.github.setxpro.challenge_itau.infra.handlers;

import com.github.setxpro.challenge_itau.domain.dtos.CustomMessageDTO;
import com.github.setxpro.challenge_itau.domain.exceptions.FieldCannotBeEmptyException;
import com.github.setxpro.challenge_itau.domain.exceptions.InvalidDateToTransactionException;
import com.github.setxpro.challenge_itau.domain.exceptions.InvalidValueToTransactionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FieldCannotBeEmptyException.class)
    public ResponseEntity<Object> handlerFieldCannotBeEmptyException(FieldCannotBeEmptyException e, WebRequest request) {
        CustomMessageDTO error = new CustomMessageDTO(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY.value());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(e, error, headers, HttpStatus.UNPROCESSABLE_ENTITY, request);
    }

    @ExceptionHandler(InvalidValueToTransactionException.class)
    public ResponseEntity<Object> handlerInvalidValueToTransactionException(InvalidValueToTransactionException e, WebRequest request) {
        CustomMessageDTO error = new CustomMessageDTO(e.getMessage(), HttpStatus.BAD_REQUEST.value());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(e, error, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(InvalidDateToTransactionException.class)
    public ResponseEntity<Object> handlerInvalidDateToTransactionException(InvalidDateToTransactionException e, WebRequest request) {
        CustomMessageDTO error = new CustomMessageDTO(e.getMessage(), HttpStatus.BAD_REQUEST.value());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(e, error, headers, HttpStatus.BAD_REQUEST, request);
    }
}
