package com.topicos.reservations.persistence.crud;

import com.topicos.reservations.domain.Reservation;
import com.topicos.reservations.persistence.entity.Reservacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ReservaMongoRepository extends MongoRepository<Reservacion, String> {
    Optional<List<Reservacion>> findByIdEstablecimiento(String idEstablecimiento, Sort sort );
    Optional<Page<Reservacion>> findByIdEstablecimiento(String idEstablecimiento, Pageable pageable);
    Optional<List<Reservacion>> findByIdUsuario(String idUsuario, Sort sort);
    Optional<Page<Reservacion>> findByIdUsuario(String idUsuario, Pageable pageable);
}

