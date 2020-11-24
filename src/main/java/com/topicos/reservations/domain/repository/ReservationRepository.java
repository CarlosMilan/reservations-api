package com.topicos.reservations.domain.repository;

import com.topicos.reservations.domain.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository {
     List<Reservation> getAll();
     Optional<Reservation> getReservation( String reservationId );
     Optional<List<Reservation>> getByEstablishment( String establishmentId );
     Optional<List<Reservation>> getByUser( String userId );
     Reservation save( Reservation reservation);
     void delete( String reservationId );
}
