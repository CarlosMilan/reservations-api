package com.topicos.reservations.persistence.crud;

import com.topicos.reservations.persistence.entity.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaMongoRepository extends MongoRepository<Reserva, String> {
}
