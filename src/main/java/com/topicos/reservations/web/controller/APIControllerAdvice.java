package com.topicos.reservations.web.controller;

import com.topicos.reservations.domain.dto.ErrorMessageDTO;
import com.topicos.reservations.domain.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class APIControllerAdvice extends DefaultHandlerExceptionResolver {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessageDTO> handleException(Exception ex) {
        ErrorMessageDTO error = new ErrorMessageDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorMessageDTO> handleException(ConstraintViolationException ex) {
        List<String> errorsDetail = new ArrayList<>();
        ex.getConstraintViolations().forEach(error -> {
            errorsDetail.add(error.getMessage());
        });
        ErrorMessageDTO errorDto = new ErrorMessageDTO(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), errorsDetail);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessageDTO> handleException(ResourceNotFoundException ex) {
        ErrorMessageDTO error = new ErrorMessageDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
