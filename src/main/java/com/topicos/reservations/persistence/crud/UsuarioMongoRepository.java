package com.topicos.reservations.persistence.crud;

import com.topicos.reservations.persistence.entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface UsuarioMongoRepository extends MongoRepository<Usuario, String> {
    public Optional<Usuario> findByEmail(String email);
}
