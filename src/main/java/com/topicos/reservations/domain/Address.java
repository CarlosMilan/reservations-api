package com.topicos.reservations.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Address {

    @NotNull(message = "El campo street no puede estar vacío")
    @Size(min = 3, max = 80, message = "La calle debe tener entre 3 y 80 caracteres")
    private String street;

    @NotNull(message = "El campo city no puede estar vacío")
    @Size(min = 3, max = 80, message = "La ciudad debe tener entre 3 y 80 caracteres")
    private String city;

    @NotNull(message = "El campo province no puede estar vacío")
    @Size(min = 3, max = 80, message = "La provincia debe tener entre 3 y 80 caracteres")
    private String province;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
