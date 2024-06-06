package com.ahmadah.clustereddatawarehouse.exception;

import com.ahmadah.clustereddatawarehouse.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DealAlreadyExistsException.class)
    public ResponseEntity<com.ahmadah.clustereddatawarehouse.response.ErrorResponse> handleDealAlreadyExistsException(DealAlreadyExistsException e, HttpServletRequest request) {
        var errorResponse=ErrorResponse.builder()
                .error("Deal Already Exists")
                .massage(e.getMessage())
                .status(HttpStatus.CONFLICT.toString())
                .path(request.getRequestURI())
                .build();
            return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", HttpStatus.BAD_REQUEST.value());
        responseBody.put("error", "Validation Failed");
        responseBody.put("errors", errors);

        return new ResponseEntity<>(responseBody,  HttpStatus.BAD_REQUEST);
    }
}
