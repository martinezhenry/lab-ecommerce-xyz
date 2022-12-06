package com.hvs.lab.ecommerce.logistics.controllers.implementations;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Error {
    private String message;
    private int status;
    private LocalDateTime timestamp;
}
