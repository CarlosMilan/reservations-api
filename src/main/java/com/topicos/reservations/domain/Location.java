package com.topicos.reservations.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Location {
    @NotNull(message = "El tipo de ubicación no puede estar vacío")
    private String type;
    private Double[] coordinates;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Double[] coordinates) {
        this.coordinates = coordinates;
    }
}
