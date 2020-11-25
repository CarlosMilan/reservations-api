package com.topicos.reservations.persistence.mapper;

import com.topicos.reservations.domain.Establishment;
import com.topicos.reservations.persistence.entity.Establecimiento;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { ReviewMapper.class })
public interface EstablishmentMapper {

    @Mappings({
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "tipo", target = "type"),
            @Mapping(source = "direccion.calle", target = "address.street"),
            @Mapping(source = "direccion.ciudad", target = "address.city"),
            @Mapping(source = "direccion.provincia", target = "address.province"),
            @Mapping(source = "telefonos", target = "phones"),
            @Mapping(source = "capacidadMaxima", target = "maxCapacity"),
            @Mapping(source = "puntuacionPromedio", target = "rating"),
            @Mapping(source = "cantidadVotos", target = "numOfVotes"),
            @Mapping(source = "ubicacion", target = "location"),
            @Mapping(source = "comentarios", target = "reviews")
    })
    Establishment toEstablishment(Establecimiento establecimiento);

    List<Establishment> toEstablishments(List<Establecimiento> establecimientos);

    @InheritInverseConfiguration
    Establecimiento toEstablecimiento( Establishment establishment);
}
