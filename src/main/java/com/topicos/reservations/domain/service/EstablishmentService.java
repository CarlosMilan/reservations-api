package com.topicos.reservations.domain.service;

import com.topicos.reservations.domain.Establishment;
import com.topicos.reservations.domain.Reservation;
import com.topicos.reservations.domain.Review;
import com.topicos.reservations.domain.User;
import com.topicos.reservations.domain.exceptions.ResourceNotFoundException;
import com.topicos.reservations.domain.repository.EstablishmentRepository;
import com.topicos.reservations.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EstablishmentService {

    @Autowired
    private EstablishmentRepository repository;

    @Autowired
    private UserRepository userRepository;

    public List<Establishment> getAll() {
        return repository.getAll();
    }

    public Page<Establishment> getAll( Pageable pageable ) {
        return repository.getAll( pageable );
    }

    public Optional<Establishment> getEstablishmentById(String establishmentId ) {
        return repository.getEstablishmentById( establishmentId );
    }

    public Optional<List<Establishment>> getByType( String type ) {
        return this.repository.getEstablishmentByType( type );
    }

    public Optional<Page<Establishment>> getByType( String type, Pageable pageable ) {
        return this.repository.getEstablishmentByType( type, pageable );
    }

    public Optional<List<Establishment>> getByAddress( String city, String province ) {
        return this.repository.getEstablishmentByAddress( city, province);
    }

    public Optional<Page<Establishment>> getByAddress( String city, String province, Pageable pageable ) {
        return this.repository.getEstablishmentByAddress( city, province, pageable );
    }

    public Optional<List<Establishment>> getByName( String name ) {
        return this.repository.getEstablishmentByName( name );
    }

    public Optional<Page<Establishment>> getByName( String name, Pageable pageable ) {
        return this.repository.getEstablishmentByName( name, pageable );
    }

    public Establishment save( Establishment establishment) {
        establishment.setRating(0D);
        establishment.setNumOfVotes(0);
        return repository.save( establishment );
    }

    public Establishment addReview(String establishmentId, Review review) {
        Establishment establishment = getEstablishment(establishmentId);
        User user = getUser(review.getUserId());

        if (establishment.getReviews() == null || establishment.getReviews().size() == 0) {
            establishment.setRating(review.getScore().doubleValue());
            review.setCreateAt( LocalDateTime.now() );
            establishment.getReviews().add(review);
            establishment.setNumOfVotes(establishment.getNumOfVotes() + 1);
            return repository.save(establishment);
        } else {

            //TODO Seguir refactorizando desde acá

            boolean existUserId = false;
            for (Review rev : establishment.getReviews()) {
                if (rev.getUserId().equals(review.getUserId())) {
                    existUserId = true;
                    break;
                }
            }

            if (!existUserId) {
                Double newRating = establishment.getRating() * establishment.getReviews().size();
                newRating += review.getScore();
                newRating = newRating / (establishment.getReviews().size() + 1);
                establishment.setRating(newRating);
                review.setCreateAt( LocalDateTime.now() );
                establishment.getReviews().add(review);
                establishment.setNumOfVotes(establishment.getNumOfVotes() + 1);
                return repository.save(establishment);
            } else return establishment;
        }

    }

    public Establishment editReview( String establishmentId, Review review ) {
        Establishment establishment = repository.getEstablishmentById( establishmentId ).get();

        if (establishment != null) {
            if ( establishment.getReviews() != null && establishment.getReviews().size() > 0) {
                Double newRating = establishment.getRating() * establishment.getReviews().size();
                for (Review rev : establishment.getReviews()) {
                    if (rev.getUserId().equals(review.getUserId())) {
                        rev.setCommentary(review.getCommentary());
                        rev.setCreateAt(review.getCreateAt());
                        newRating -= rev.getScore();
                        newRating += review.getScore();
                        rev.setScore(review.getScore());
                        break;
                    }
                }
                newRating = newRating / establishment.getReviews().size();
                establishment.setRating( newRating );
                return repository.save( establishment );
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public boolean deleteReview( String establishmentId, String userId ) {
        Establishment establishment = repository.getEstablishmentById( establishmentId ).get();
        if ( establishment != null ) {
            if (establishment.getReviews() != null ) {
                if (establishment.getReviews().size() > 0) {
                    for (int i = 0; i < establishment.getReviews().size() ; i++) {
                        if (establishment.getReviews().get(i).getUserId().equals(userId)) {

                            Double newRating = establishment.getRating() * establishment.getReviews().size();
                            newRating -= establishment.getReviews().get(i).getScore();
                            newRating = newRating / (establishment.getReviews().size() - 1 );

                            establishment.getReviews().remove(i);
                            if (establishment.getReviews().size() == 0) {
                                establishment.setNumOfVotes( 0 );
                                establishment.setRating( 0D );
                            } else {
                                establishment.setNumOfVotes( establishment.getNumOfVotes() - 1 );
                                establishment.setRating(newRating);
                            }

                            repository.save( establishment );
                            break;
                        }
                    }
                    return true;
                } else return false;
            } else return false;
        } else {
            return false;
        }
    }

    private Establishment getEstablishment(String establishmentId) {
        return repository
                .getEstablishmentById(establishmentId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro establecimiento con id: " + establishmentId));
    }

    private User getUser(String userId) {
        return userRepository
                .getUserById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro usuario con id: " + userId));
    }

    public boolean delete( String establishmentId ) {
        return getEstablishmentById( establishmentId ).map( establishment -> {
            repository.delete( establishmentId);
            return true;
        }).orElse(false);
    }
}
