package com.topicos.reservations.web.controller;

import com.topicos.reservations.domain.Reservation;
import com.topicos.reservations.domain.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getAll() {
        return new ResponseEntity<>( reservationService.getAll(), HttpStatus.OK );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation( @PathVariable("id") String reservationId ) {
        if ( reservationId.length() == 0 || reservationId == null ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        } else {
            return reservationService.getReservation( reservationId )
                    .map( reservation -> new ResponseEntity<>( reservation, HttpStatus.OK))
                    .orElse( new ResponseEntity<>( HttpStatus.NOT_FOUND ));
        }
    }

    @GetMapping("/establishment/{id}")
    public ResponseEntity<List<Reservation>> getByEstablishment(@PathVariable("id") String establishmentId) {
        if ( establishmentId == null || establishmentId.length() == 0) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        } else {
            return reservationService.getByEstablishment( establishmentId )
                    .map( reservations -> new ResponseEntity<>( reservations, HttpStatus.OK ))
                    .orElse( new ResponseEntity<>( HttpStatus.NOT_FOUND ) );
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Reservation>> getByUser(@PathVariable("id") String userId) {
        if ( userId == null || userId.length() == 0) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        } else {
            return reservationService.getByUser( userId )
                    .map( reservations -> new ResponseEntity<>( reservations, HttpStatus.OK ))
                    .orElse( new ResponseEntity<>( HttpStatus.NOT_FOUND ) );
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Reservation> save( @RequestBody Reservation reservation) {
        if ( reservation != null ) {
            System.out.println("reservation = " + reservation);
            return new ResponseEntity<>( reservationService.save( reservation ), HttpStatus.CREATED );
        } else {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete( @PathVariable("id") String reservationId ) {
        if ( reservationId.length() == 0 || reservationId == null ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        } else {
            if (reservationService.delete(reservationId)) {
                return new ResponseEntity(HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }
    }
}
