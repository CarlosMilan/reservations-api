package com.topicos.reservations.web.controller;

import com.topicos.reservations.domain.User;
import com.topicos.reservations.domain.service.UserService;
import com.topicos.reservations.persistence.crud.UsuarioMongoRepository;
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
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll(){
        //List<Usuario> usuarios = repository.findAll();
        return new ResponseEntity<>( userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") String userId) {

        return userService.getUser( userId )
                .map( user -> new ResponseEntity<>( user, HttpStatus.OK))
                .orElse( new ResponseEntity<>( HttpStatus.NOT_FOUND ));
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user) {
        return new ResponseEntity<>( userService.save( user ), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") String userId) {
        if (userService.delete( userId )) {
            return new ResponseEntity( HttpStatus.OK);
        } else {
            return new ResponseEntity( HttpStatus.NOT_FOUND );
        }
    }



}
