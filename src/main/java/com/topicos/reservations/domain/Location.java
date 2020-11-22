package com.topicos.reservations.domain;

import lombok.Data;

@Data
public class Location {
    private String type;
    private Double[] coordinates;
}
