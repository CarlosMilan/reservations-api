package com.topicos.reservations.web.controller;

import com.topicos.reservations.domain.Establishment;
import com.topicos.reservations.domain.Review;
import com.topicos.reservations.domain.service.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Establishment> getEstablishment(@PathVariable("id") String establishmentId ) {
        if ( establishmentId.length() == 0 || establishmentId == null ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        } else {
            return establishmentService.getEstablishment( establishmentId )
                    .map( establishment -> new ResponseEntity<>( establishment, HttpStatus.OK))
                    .orElse( new ResponseEntity<>( HttpStatus.NOT_FOUND ));
        }

    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Establishment>> getByType(@PathVariable("type") String type) {
        if ( type.length() == 0 || type == null) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        } else {
            return establishmentService.getByType( type )
                    .map( establishments -> new ResponseEntity<>( establishments, HttpStatus.OK))
                    .orElse( new ResponseEntity<>( HttpStatus.NOT_FOUND ));
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Establishment>> getByName(@PathVariable("name") String name) {
        if (name.length() == 0 || name == null) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        } else {
            return establishmentService.getByName(name)
                    .map(establishments -> new ResponseEntity<>(establishments, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
    }

    @GetMapping("/address/{city}/{province}")
    public ResponseEntity<List<Establishment>> getByAddress(@PathVariable("city") String city, @PathVariable("province") String province) {
        if ( city.length() == 0 || city == null || province.length() ==0 || province == null ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        } else {
            return establishmentService.getByAddress(city, province)
                    .map( establishments -> new ResponseEntity<>( establishments, HttpStatus.OK))
                    .orElse( new ResponseEntity<>( HttpStatus.NOT_FOUND ));
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Establishment> save( @RequestBody Establishment establishment ) {
        if ( establishment != null ) {
            return new ResponseEntity<>(establishmentService.save(establishment), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @PutMapping("/add/review/{id}")
    public ResponseEntity<Establishment> addReview(@PathVariable("id") String establishmentId, @RequestBody Review review) {
        if ( establishmentId.length() == 0 || establishmentId == null || review == null ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        } else {
            Establishment establishment = establishmentService.addReview( establishmentId, review );
            if ( establishment != null){
                return new ResponseEntity<>( establishment , HttpStatus.CREATED);
            } else return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
    }

    @PutMapping("/edit/review/{id}")
    public ResponseEntity<Establishment> editReview(@PathVariable("id") String establishmentId, @RequestBody Review review) {
        if ( establishmentId.length() == 0 || establishmentId == null || review == null ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        } else {
            return new ResponseEntity<>( establishmentService.editReview( establishmentId, review ), HttpStatus.CREATED );
        }
    }
    @DeleteMapping("/delete/review/{id}/{userId}")
    public ResponseEntity deleteReview( @PathVariable("id") String establishmentId, @PathVariable("userId") String userId) {
        if ( establishmentId.length() == 0 || establishmentId == null || userId.length() == 0 || userId == null ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        } else {
            if (establishmentService.deleteReview(establishmentId, userId)) {
                return new ResponseEntity(HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete( @PathVariable("id") String establishmentId ) {
        if ( establishmentId.length() == 0 || establishmentId == null ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        } else {
            if (establishmentService.delete(establishmentId)) {
                return new ResponseEntity(HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }
    }
}
