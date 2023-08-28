package com.example.blogsystemapi.Api;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ApiExeption extends RuntimeException {
    public ApiExeption(String message) {
        super(message);

    }
}
