package com.topicos.reservations.domain.repository;

import com.topicos.reservations.domain.Establishment;

import java.util.List;
import java.util.Optional;

public interface EstablishmentRepository {
    List<Establishment> getAll();
    Optional<Establishment> getEstablishment( String establishmentId );
    Optional<List<Establishment>> getBestRated();
    Establishment save(Establishment establishment);
    void delete( String establishmentId);
}
