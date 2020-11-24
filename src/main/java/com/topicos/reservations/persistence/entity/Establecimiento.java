package com.topicos.reservations.persistence.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "establecimientos")
public class Establecimiento {

    @Id
    private String id;
    private String nombre;
    private String tipo;
    private Direccion direccion;
    private Integer capacidadMaxima;
    private Double puntuacionPromedio;
    private Integer cantidadVotos;
    private Ubicacion ubicacion;
    private List<Comentario> comentarios;

    public Establecimiento() {
        comentarios = new ArrayList<Comentario>();
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Integer getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(Integer capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public Double getPuntuacionPromedio() {
        return puntuacionPromedio;
    }

    public void setPuntuacionPromedio(Double puntuacionPromedio) {
        this.puntuacionPromedio = puntuacionPromedio;
    }

    public Integer getCantidadVotos() {
        return cantidadVotos;
    }

    public void setCantidadVotos(Integer cantidadVotos) {
        this.cantidadVotos = cantidadVotos;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
