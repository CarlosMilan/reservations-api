package com.topicos.reservations.persistence.mapper;

import com.topicos.reservations.domain.User;
import com.topicos.reservations.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", uses = { AddressMapper.class })
public interface UserMapper {

    @Mappings({
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "apellido", target = "lastName"),
            @Mapping(source = "direccion.calle", target = "address.street"),
            @Mapping(source = "direccion.ciudad", target = "address.city"),
            @Mapping(source = "direccion.provincia", target = "address.province"),
            @Mapping(source = "telefonos", target = "phones")
    })
    User toUser(Usuario usuario);

    List<User> toUsers(List<Usuario> usuarios);

    @InheritInverseConfiguration
    Usuario toUsuario(User user);
}
