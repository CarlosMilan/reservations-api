package com.topicos.reservations.persistence;

import com.topicos.reservations.domain.Establishment;
import com.topicos.reservations.domain.repository.EstablishmentRepository;
import com.topicos.reservations.persistence.crud.EstablecimientoMongoRepository;
import com.topicos.reservations.persistence.entity.Establecimiento;
import com.topicos.reservations.persistence.mapper.EstablishmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EstablecimientoRepository implements EstablishmentRepository {

    @Autowired
    private EstablecimientoMongoRepository establecimientoMongoRepository;

    @Autowired
    private EstablishmentMapper mapper;

    @Override
    public List<Establishment> getAll() {
        return mapper.toEstablishments( (List<Establecimiento>) establecimientoMongoRepository.findAll() );
    }

    @Override
    public Optional<Establishment> getEstablishment(String establishmentId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Establishment>> getBestRated() {
        return Optional.empty();
    }

    @Override
    public Establishment save(Establishment establishment) {
        return null;
    }

    @Override
    public void delete(String establishmentId) {

    }
}
