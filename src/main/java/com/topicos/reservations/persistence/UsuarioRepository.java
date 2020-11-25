package com.topicos.reservations.persistence;

import com.topicos.reservations.domain.User;
import com.topicos.reservations.domain.repository.UserRepository;
import com.topicos.reservations.persistence.crud.UsuarioMongoRepository;
import com.topicos.reservations.persistence.entity.Usuario;
import com.topicos.reservations.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements UserRepository {

    @Autowired
    private UsuarioMongoRepository usuarioMongoRepository;

    @Autowired
    private UserMapper mapper;


    @Override
    public List<User> getAll() {
        return mapper.toUsers( (List<Usuario>) usuarioMongoRepository.findAll() );
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return usuarioMongoRepository.findAll( pageable ).map(mapper::toUser);
    }

    @Override
    public Optional<User> getUser(String userId) {
        return this.usuarioMongoRepository.findById( userId ).map( usuario -> mapper.toUser( usuario ));
    }

    @Override
    public User save(User user) {
        Usuario usuario = mapper.toUsuario( user );
        return this.mapper.toUser( this.usuarioMongoRepository.save( usuario ) );
    }

    @Override
    public void delete(String userId) {
        this.usuarioMongoRepository.deleteById( userId );
    }
}
