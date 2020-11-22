package com.topicos.reservations.persistence.crud;

import com.topicos.reservations.persistence.entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioMongoRepository extends MongoRepository<Usuario, String> {
}
