package com.topicos.reservations.persistence.mapper;

import com.topicos.reservations.domain.Reservation;
import com.topicos.reservations.persistence.entity.Reservacion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mappings({
            @Mapping(source = "idUsuario", target = "userId"),
            @Mapping(source = "idEstablecimiento", target = "establishmentId"),
            @Mapping(source = "nombreEstablecimiento", target = "establishmentName"),
            @Mapping(source = "fechaReserva", target = "reservationDate"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "cantPersonas", target = "amountOfPeople"),
            @Mapping(source = "cantMesas", target = "numberOfTables"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "fechaCreacion", target = "createAt")
    })
    Reservation toReservation( Reservacion reservacion );
    List<Reservation> toReservations( List<Reservacion> reservaciones );

    @InheritInverseConfiguration
    Reservacion toReservacion( Reservation reservation);
}
