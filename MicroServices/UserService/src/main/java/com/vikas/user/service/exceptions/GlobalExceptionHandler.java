package com.vikas.user.service.exceptions;

import com.vikas.user.service.dto.ApiResponse;
import com.vikas.user.service.entity.User;
import com.vikas.user.service.repositery.UserRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private UserRepositery userRepositery;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){

        String message=ex.getMessage();
        ApiResponse apiResponse= ApiResponse.builder().message(message).isSuccess(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);

    }
    public ResponseEntity<?> getUser(Long userId) {
        User user = userRepositery.findByUserId(userId);

        if (user == null) {
            // User not found, return a custom response
            String errorMessage = "User not found with id: " + userId;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }

        // User found, return the user object
        return ResponseEntity.ok(user);
    }

}
