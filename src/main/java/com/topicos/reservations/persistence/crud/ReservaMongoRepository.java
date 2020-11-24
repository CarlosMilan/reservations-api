package com.topicos.reservations.persistence.crud;

import com.topicos.reservations.persistence.entity.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservaMongoRepository extends MongoRepository<Reserva, String> {
}
