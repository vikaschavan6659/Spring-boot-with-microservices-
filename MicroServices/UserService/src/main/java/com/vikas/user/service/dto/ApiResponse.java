package com.vikas.user.service.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ApiResponse {

    private String message;
    private boolean isSuccess;
    private HttpStatus status;
}
