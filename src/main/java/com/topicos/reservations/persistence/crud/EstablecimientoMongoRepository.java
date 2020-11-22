package com.topicos.reservations.persistence.crud;

import com.topicos.reservations.persistence.entity.Establecimiento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface EstablecimientoMongoRepository extends MongoRepository<Establecimiento, String> {
}
