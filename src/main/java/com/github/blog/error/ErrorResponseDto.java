package com.github.blog.error;

public class ErrorResponseDto {
    private final String message;

    public String getMessage() {
        return message;
    }

    public ErrorResponseDto(String message) {
        this.message = message;
    }
}
