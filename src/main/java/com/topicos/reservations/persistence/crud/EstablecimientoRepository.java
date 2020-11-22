package com.topicos.reservations.persistence.crud;

import com.topicos.reservations.persistence.entity.Establecimiento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablecimientoRepository extends MongoRepository<Establecimiento, String> {
}
