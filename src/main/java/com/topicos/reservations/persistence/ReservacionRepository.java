package com.topicos.reservations.persistence;

import com.topicos.reservations.domain.Reservation;
import com.topicos.reservations.domain.repository.ReservationRepository;
import com.topicos.reservations.persistence.crud.ReservaMongoRepository;
import com.topicos.reservations.persistence.entity.Reservacion;
import com.topicos.reservations.persistence.mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservacionRepository implements ReservationRepository {

    @Autowired
    private ReservaMongoRepository reservaMongoRepository;

    @Autowired
    private ReservationMapper mapper;

    @Override
    public List<Reservation> getAll() {
        return mapper.toReservations( (List<Reservacion>) reservaMongoRepository.findAll() );
    }

    @Override
    public Optional<Reservation> getReservation(String reservationId) {
        return this.reservaMongoRepository.findById( reservationId )
                .map( reservacion -> mapper.toReservation( reservacion ));
    }

    @Override
    public Optional<List<Reservation>> getByEstablishment(String establishmentId) {
        Optional<List<Reservacion>> reservaciones = this.reservaMongoRepository.findByIdEstablecimiento( establishmentId, Sort.by(Sort.Direction.DESC, "fechaCreacion") );
        return reservaciones.map( res -> mapper.toReservations( res ));
    }

    @Override
    public Optional<List<Reservation>> getByUser(String userId) {
        Optional<List<Reservacion>> reservaciones = this.reservaMongoRepository.findByIdUsuario( userId, Sort.by(Sort.Direction.DESC, "fechaCreacion") );
        return reservaciones.map( res -> mapper.toReservations( res ));
    }

    @Override
    public Reservation save(Reservation reservation) {
        Reservacion reservacion = mapper.toReservacion( reservation );
        return this.mapper.toReservation( this.reservaMongoRepository.save( reservacion ) );
    }

    @Override
    public void delete(String reservationId) {
        this.reservaMongoRepository.deleteById( reservationId );
    }
}
