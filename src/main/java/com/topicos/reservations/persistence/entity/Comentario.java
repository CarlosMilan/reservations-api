package com.topicos.reservations.persistence.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Comentario {
    private String idUsuario;
    private Integer calificacion;
    private String mensaje;
    private Date fechaCreacion;
}
