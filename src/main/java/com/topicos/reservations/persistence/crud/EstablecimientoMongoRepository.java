package com.topicos.reservations.persistence.crud;

import com.topicos.reservations.persistence.entity.Establecimiento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EstablecimientoMongoRepository extends MongoRepository<Establecimiento, String> {
    Optional<List<Establecimiento>> findByDireccionCiudadIgnoreCaseAndDireccionProvinciaIgnoreCase( String ciudad, String provincia );
    Optional<Page<Establecimiento>> findByDireccionCiudadIgnoreCaseAndDireccionProvinciaIgnoreCase(String ciudad, String provincia, Pageable pageable);
    Optional<List<Establecimiento>> findByTipoIgnoreCase( String tipo );
    Optional<Page<Establecimiento>> findByTipoIgnoreCase( String tipo, Pageable pageable );
    Optional<List<Establecimiento>> findByNombreIgnoreCase( String nombre );
    Optional<Page<Establecimiento>> findByNombreIgnoreCase( String nombre, Pageable pageable );
}
