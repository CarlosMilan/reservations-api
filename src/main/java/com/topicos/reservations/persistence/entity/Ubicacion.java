package com.topicos.reservations.persistence.entity;

import lombok.Data;

@Data
public class Ubicacion {
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
