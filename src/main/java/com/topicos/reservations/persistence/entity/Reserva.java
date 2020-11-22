package com.topicos.reservations.persistence.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "reservas")
public class Reserva {
    @Id
    private String id;

    private String idUsuario;
    private String idEstablecimiento;
    private Date fechaReserva;
    private Integer cantPersonas;
    private Integer cantMesas;
    private String estado;
    private Date fechaCreacion;
}
