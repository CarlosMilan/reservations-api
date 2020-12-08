package com.topicos.reservations.persistence.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Sharded;

import java.util.ArrayList;
import java.util.List;

/**
 * La anotacion @Sharded dentro de la cual se indica cual es la shard key es necesaria, de lo contrario no se podrán
 * realizar updates sobre los documentos
 */
@Data
@Document(collection = "usuarios")
@Sharded(shardKey = {"email"})
public class Usuario {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private Direccion direccion;
    private String email;
    private String password;
    private List<String> telefonos;

    public Usuario() {
        telefonos = new ArrayList<String>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<String> telefonos) {
        this.telefonos = telefonos;
    }

}
