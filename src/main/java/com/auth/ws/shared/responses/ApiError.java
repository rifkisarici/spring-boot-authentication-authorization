package com.auth.ws.shared.responses;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ApiError {
    private int status;
    private String message;
    private String path;
    private LocalDateTime time = LocalDateTime.now();
    private Map<String, String> validationErrors;

    public ApiError(int status, String message, String path) {
        this.status = status;
        this.message = message;
        this.path = path;
    }
}
