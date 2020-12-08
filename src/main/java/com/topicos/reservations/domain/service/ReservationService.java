package com.topicos.reservations.domain.service;

import com.topicos.reservations.domain.Establishment;
import com.topicos.reservations.domain.Reservation;
import com.topicos.reservations.domain.User;
import com.topicos.reservations.domain.repository.EstablishmentRepository;
import com.topicos.reservations.domain.repository.ReservationRepository;
import com.topicos.reservations.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EstablishmentRepository establishmentRepository;

    public List<Reservation> getAll() {
        return this.reservationRepository.getAll();
    }

    public Page<Reservation> getAll( Pageable pageable ) {
        return this.reservationRepository.getAll( pageable );
    }

    public Optional<Reservation> getReservation( String reservationId ) {
        return this.reservationRepository.getReservation( reservationId );
    }

    public Optional<List<Reservation>> getByEstablishment( String establishmentId ) {
        return this.reservationRepository.getByEstablishment( establishmentId );
    }

    public Optional<Page<Reservation>> getByEstablishment( String establishmentId, Pageable pageable ) {
        return this.reservationRepository.getByEstablishment( establishmentId, pageable );
    }

    public Optional<List<Reservation>> getByUser( String userId ) {
        return this.reservationRepository.getByUser( userId );
    }

    public Optional<Page<Reservation>> getByUser( String userId, Pageable pageable ) {
        return this.reservationRepository.getByUser( userId, pageable );
    }

    public Optional<Page<Reservation>> getByEstablishmentName( String establishmentName, Pageable pageable ) {
        return this.reservationRepository.getByEstablishmentName( establishmentName, pageable );
    }


    public Reservation save( Reservation reservation ) {
        if (reservation.getEstablishmentId() == null || reservation.getEstablishmentId().length() == 0 || reservation.getUserId() == null || reservation.getUserId().length() == 0 ) {
            return null;
        } else {
            Establishment establishment = establishmentRepository.getEstablishment(reservation.getEstablishmentId()).get();
            User user = userRepository.getUser(reservation.getUserId()).get();
            System.out.println("user = " + user);
            if (establishment != null && user != null) {
                if ( reservation.getName() == null || reservation.getName().length() == 0) {
                    String name = user.getName() + " " + user.getLastName();
                    reservation.setName( name );
                    LocalDateTime dateTime = LocalDateTime.now();
                    reservation.setCreateAt( dateTime );
                }
                reservation.setEstablishmentName( establishment.getName() );
                Reservation res = reservationRepository.save( reservation );
                //userRepository.save( user );
                System.out.println("EL USUARIO SE GUARDÓ: user = " + user);
                return res;
            } else {
                return null;
            }
        }
    }


    public boolean delete( String reservationId ) {
        return getReservation( reservationId ).map( reservation -> {
            reservationRepository.delete( reservationId );
            return true;
        }).orElse(false);
    }

}
