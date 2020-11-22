package com.topicos.reservations.domain.service;

import com.topicos.reservations.domain.Establishment;
import com.topicos.reservations.domain.repository.EstablishmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstablishmentService {

    @Autowired
    private EstablishmentRepository repository;

    public List<Establishment> getAll() {
        return repository.getAll();
    }

    public Establishment save( Establishment establishment) {
        return repository.save( establishment );
    }
}
