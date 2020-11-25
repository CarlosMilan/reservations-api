package com.topicos.reservations.domain.repository;

import com.topicos.reservations.domain.Establishment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EstablishmentRepository {
    List<Establishment> getAll();
    Page<Establishment> getAll( Pageable pageable );
    Optional<Establishment> getEstablishment( String establishmentId );
    Optional<List<Establishment>> getEstablishmentByAddress( String city, String province );
    Optional<Page<Establishment>> getEstablishmentByAddress( String city, String province, Pageable pageable );
    Optional<List<Establishment>> getEstablishmentByType( String type );
    Optional<Page<Establishment>> getEstablishmentByType( String type, Pageable pageable );
    Optional<List<Establishment>> getEstablishmentByName( String name );
    Optional<Page<Establishment>> getEstablishmentByName( String name, Pageable pageable );
    Establishment save(Establishment establishment);
    void delete( String establishmentId);
}
