package com.topicos.reservations.persistence.crud;

import com.topicos.reservations.persistence.entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UsuarioMongoRepository extends MongoRepository<Usuario, String> {
}
