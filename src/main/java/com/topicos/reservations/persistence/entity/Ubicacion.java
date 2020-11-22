package com.topicos.reservations.persistence.entity;

import lombok.Data;

@Data
public class Ubicacion {
    private String type;
    private Double[] coordinates;
}
