package com.topicos.reservations.domain.repository;

import com.topicos.reservations.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAll();
    Optional<User> getUser(String userId);
    User save(User user);
    void delete(String userId);
}
