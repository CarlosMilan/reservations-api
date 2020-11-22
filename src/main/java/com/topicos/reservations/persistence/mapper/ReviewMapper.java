package com.topicos.reservations.persistence.mapper;

import com.topicos.reservations.domain.Review;
import com.topicos.reservations.persistence.entity.Comentario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    @Mappings({
        @Mapping(source = "idUsuario", target = "userId"),
        @Mapping(source = "calificacion", target = "score"),
        @Mapping(source = "mensaje", target = "commentary"),
        @Mapping(source = "fechaCreacion", target = "createAt")
    })
    Review toReview(Comentario comentario);

    List<Review> toReviews(List<Comentario> comentarios);

    @InheritInverseConfiguration
    Comentario toComentario(Review review);
}
