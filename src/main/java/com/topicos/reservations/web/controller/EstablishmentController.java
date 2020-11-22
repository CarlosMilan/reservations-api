package com.topicos.reservations.web.controller;

import com.topicos.reservations.domain.Establishment;
import com.topicos.reservations.domain.service.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/establishments")
public class EstablishmentController {

    @Autowired
    private EstablishmentService establishmentService;

    @GetMapping("/all")
    public ResponseEntity<List<Establishment>> getAll() {
        return new ResponseEntity<>( establishmentService.getAll(), HttpStatus.OK );
    }
}
