package com.workshop.workshopapi.controller;

import com.workshop.workshopapi.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiException handleValidationErrors(MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();
        Stream<String> defaultMessages = result.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage());

        return new ApiException(defaultMessages.collect(Collectors.toList()));
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiException> handleStatusException(ResponseStatusException exception) {
        ApiException apiException = new ApiException(exception.getMessage());
        return ResponseEntity.badRequest().body(apiException);
    }
}
