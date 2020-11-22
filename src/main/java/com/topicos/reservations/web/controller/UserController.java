package com.topicos.reservations.web.controller;

import com.topicos.reservations.persistence.crud.UsuarioRepository;
import com.topicos.reservations.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping("/all")
    public List<Usuario> getAll(){
        //List<Usuario> usuarios = repository.findAll();
        return this.repository.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
        return new ResponseEntity<>( repository.save( usuario ), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getUser(@PathVariable("id") String userId) {
        return repository.findById( userId );
    }

}
