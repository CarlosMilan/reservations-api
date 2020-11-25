package com.topicos.reservations.persistence.crud;

import com.topicos.reservations.persistence.entity.Establecimiento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EstablecimientoMongoRepository extends MongoRepository<Establecimiento, String> {
    Optional<List<Establecimiento>> findByDireccionCiudadAndDireccionProvincia( String ciudad, String provincia );
    Optional<Page<Establecimiento>> findByDireccionCiudadAndDireccionProvincia(String ciudad, String provincia, Pageable pageable);
    Optional<List<Establecimiento>> findByTipo( String tipo );
    Optional<Page<Establecimiento>> findByTipo( String tipo, Pageable pageable );
    Optional<List<Establecimiento>> findByNombre( String nombre );
    Optional<Page<Establecimiento>> findByNombre( String nombre, Pageable pageable );
}
