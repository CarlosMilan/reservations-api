package com.topicos.reservations.domain.service;

import com.topicos.reservations.domain.User;
import com.topicos.reservations.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return this.userRepository.getAll();
    }

    public Optional<User> getUser( String userId) {
        return this.userRepository.getUser( userId );
    }

    public User save( User user) {
        return this.userRepository.save( user );
    }

    public boolean delete( String userId) {
        return getUser( userId ).map( user -> {
            userRepository.delete( userId );
            return true;
        }).orElse(false);
    }
}
