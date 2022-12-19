package com.topicos.reservations.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class User {
    private String id;

    @NotNull(message = "El nombre del usuario no puede estar vacío")
    private String name;

    @NotNull(message = "El apellido del usuario no puede estar vacío")
    private String lastName;

    @NotNull(message = "La dirección del usuario no puede estar vacía")
    private Address address;

    @NotNull(message = "El email del usuario no puede estar vacío")
    @Pattern(regexp = "^[0-9a-zA-Z.\\-_]+@[0-9a-zA-Z]+(\\.[a-zA-Z]+)+$", message = "El correo electrónico tiene un formato incorrecto")
    private String email;

    @NotNull(message = "La contraseña no puede estar vacía")
    @Size(min = 4, max = 30, message = "La contraseña tiene que tener entre 4 y 30 caracteres")
    private String password;
    private List<@NotNull(message = "El telefono no puede estar vacío")String> phones;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPhones() {
        return phones;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }
}
