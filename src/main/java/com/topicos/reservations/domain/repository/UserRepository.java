package com.topicos.reservations.domain.repository;

import com.topicos.reservations.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAll();
    Page<User> getAll(Pageable pageable);
    Optional<User> getUserById(String userId);
    Optional<User> findByUsername(String username);
    User save(User user);
    void delete(String userId);
}
