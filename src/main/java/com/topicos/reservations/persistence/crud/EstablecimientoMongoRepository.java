package com.topicos.reservations.persistence.crud;

import com.topicos.reservations.persistence.entity.Establecimiento;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EstablecimientoMongoRepository extends MongoRepository<Establecimiento, String> {
    /**
     *     Optional<List<Establishment>> getEstablishmentByAddress( String city, String province );
     *     Optional<List<Establishment>> getEstablishmentByType( String type );
     *     Optional<List<Establishment>> getEstablishmentByName( String name );
     */
    Optional<List<Establecimiento>> findByDireccionCiudadAndDireccionProvincia( String ciudad, String provincia );
    Optional<List<Establecimiento>> findByTipo( String tipo );
    Optional<List<Establecimiento>> findByNombre( String nombre );
}
