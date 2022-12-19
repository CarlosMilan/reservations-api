package com.topicos.reservations.web.controller;

import com.topicos.reservations.domain.Reservation;
import com.topicos.reservations.domain.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/page/all")
    public ResponseEntity<Page<Reservation>> getAll( @PageableDefault(page = 0, size = 10, sort = "fechaCreacion", direction = Sort.Direction.DESC) Pageable pageable) {
        return new ResponseEntity<>( reservationService.getAll( pageable ), HttpStatus.OK );
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


    @GetMapping("/establishment/page/{id}")
    public ResponseEntity<Page<Reservation>> getByEstablishment(@PathVariable("id") String establishmentId,
                                                                @PageableDefault(page = 0, size = 10, sort = "fechaCreacion", direction = Sort.Direction.DESC) Pageable pageable) {
        if ( establishmentId == null || establishmentId.length() == 0) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        } else {
            return reservationService.getByEstablishment( establishmentId, pageable )
                    .map( reservationsPage -> new ResponseEntity<>( reservationsPage, HttpStatus.OK ))
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

    @GetMapping("/establishment/page/name/{name}")
    public ResponseEntity<Page<Reservation>> getByEstablishmentName( @PathVariable("name") String establishmentName,
                                                                     @PageableDefault(page = 0, size = 10, sort = "fechaCreacion", direction = Sort.Direction.DESC) Pageable pageable) {

        if ( establishmentName == null || establishmentName.length() == 0) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        } else {
            return reservationService.getByEstablishmentName( establishmentName, pageable )
                    .map( reservationsPage -> new ResponseEntity<>( reservationsPage, HttpStatus.OK ))
                    .orElse( new ResponseEntity<>( HttpStatus.NOT_FOUND ) );
        }

    }

    @GetMapping("/user/page/{id}")
    public ResponseEntity<Page<Reservation>> getByUser(@PathVariable("id") String userId,
                                                       @PageableDefault(page = 0, size = 10, sort = "fechaCreacion", direction = Sort.Direction.DESC) Pageable pageable) {
        if ( userId == null || userId.length() == 0) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        } else {
            return reservationService.getByUser( userId, pageable )
                    .map( reservationsPage -> new ResponseEntity<>( reservationsPage, HttpStatus.OK ))
                    .orElse( new ResponseEntity<>( HttpStatus.NOT_FOUND ) );
        }
    }


    @PostMapping("/save")
    public ResponseEntity<Reservation> save( @Valid @RequestBody Reservation reservation) {
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
