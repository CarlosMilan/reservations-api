package com.topicos.reservations.persistence.mapper;

import com.topicos.reservations.domain.Address;
import com.topicos.reservations.persistence.entity.Direccion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mappings({
            @Mapping(source = "calle", target = "street"),
            @Mapping(source = "ciudad", target = "city"),
            @Mapping(source = "provincia", target = "province")
    })
    Address toAddress(Direccion direccion);

    @InheritInverseConfiguration
    Direccion toDireccion(Address address);
}
