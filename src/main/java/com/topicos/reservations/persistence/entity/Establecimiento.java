package com.topicos.reservations.persistence.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

}
