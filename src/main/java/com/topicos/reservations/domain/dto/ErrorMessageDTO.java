package com.topicos.reservations.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ErrorMessageDTO {
    private Integer code;
    private String message;
    private List<String> details;
}
