package com.menu.demoecommerce.category.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse {
    private final boolean success;
    private final String message;
    public String getTimestamp() {
        return LocalDateTime.now().toString();
    }
}
