package com.topicos.reservations.domain.repository;

import com.topicos.reservations.domain.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository {
     List<Reservation> getAll();
     Page<Reservation> getAll( Pageable pageable );
     Optional<Reservation> getReservation( String reservationId );
     Optional<List<Reservation>> getByEstablishment( String establishmentId );
     Optional<Page<Reservation>> getByEstablishment( String establishmentId, Pageable pageable );
     Optional<Page<Reservation>> getByEstablishmentName( String establishmentName, Pageable pageable );
     Optional<List<Reservation>> getByUser( String userId );
     Optional<Page<Reservation>> getByUser( String userId, Pageable pageable );
     Reservation save( Reservation reservation);
     void delete( String reservationId );
}
