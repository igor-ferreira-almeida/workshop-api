package com.workshop.workshopapi.exception;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiException {
    @Getter
    private List<String> errors;

    public ApiException(List<String> errors) {
        this.errors = errors;
    }

    public ApiException(String error) {
        this.errors = Arrays.asList(error);
    }
}
