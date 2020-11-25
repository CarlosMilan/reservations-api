package com.topicos.reservations.persistence;

import com.topicos.reservations.domain.Establishment;
import com.topicos.reservations.domain.repository.EstablishmentRepository;
import com.topicos.reservations.persistence.crud.EstablecimientoMongoRepository;
import com.topicos.reservations.persistence.entity.Establecimiento;
import com.topicos.reservations.persistence.mapper.EstablishmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EstablecimientoRepository implements EstablishmentRepository {

    @Autowired
    private EstablecimientoMongoRepository establecimientoMongoRepository;

    @Autowired
    private EstablishmentMapper mapper;

    @Override
    public List<Establishment> getAll() {
        return mapper.toEstablishments( (List<Establecimiento>) establecimientoMongoRepository.findAll() );
    }

    @Override
    public Page<Establishment> getAll(Pageable pageable) {
        return establecimientoMongoRepository.findAll( pageable ).map( mapper::toEstablishment );
    }

    @Override
    public Optional<Establishment> getEstablishment(String establishmentId) {
        return this.establecimientoMongoRepository.findById( establishmentId )
                .map( establecimiento -> mapper.toEstablishment( establecimiento ));
    }

    @Override
    public Optional<List<Establishment>> getEstablishmentByAddress(String city, String province) {
        Optional<List<Establecimiento>> establecimientos = this.establecimientoMongoRepository.findByDireccionCiudadAndDireccionProvincia( city, province );

        return establecimientos.map( ests -> mapper.toEstablishments( ests ) );
    }

    @Override
    public Optional<Page<Establishment>> getEstablishmentByAddress(String city, String province, Pageable pageable) {
        Optional<Page<Establecimiento>> establecimientos = establecimientoMongoRepository.findByDireccionCiudadAndDireccionProvincia( city, province, pageable);
        return establecimientos.map( est -> est.map( mapper::toEstablishment ));
    }

    @Override
    public Optional<List<Establishment>> getEstablishmentByType(String type) {
        Optional<List<Establecimiento>> establecimientos = this.establecimientoMongoRepository.findByTipo( type );

        return establecimientos.map( ests -> mapper.toEstablishments( ests ) );
    }

    @Override
    public Optional<Page<Establishment>> getEstablishmentByType(String type, Pageable pageable) {
        Optional<Page<Establecimiento>> establecimientos = establecimientoMongoRepository.findByTipo( type, pageable);
        return establecimientos.map( est -> est.map( mapper::toEstablishment ));
    }

    @Override
    public Optional<List<Establishment>> getEstablishmentByName(String name) {
        Optional<List<Establecimiento>> establecimientos = this.establecimientoMongoRepository.findByNombre( name );

        return establecimientos.map( ests -> mapper.toEstablishments( ests ) );
    }

    @Override
    public Optional<Page<Establishment>> getEstablishmentByName(String name, Pageable pageable) {
        Optional<Page<Establecimiento>> establecimientos = establecimientoMongoRepository.findByNombre( name, pageable);
        return establecimientos.map( est -> est.map( mapper::toEstablishment ));
    }

    @Override
    public Establishment save(Establishment establishment) {
        Establecimiento establecimiento = mapper.toEstablecimiento( establishment );
        return this.mapper.toEstablishment( this.establecimientoMongoRepository.save( establecimiento ));

    }

    @Override
    public void delete(String establishmentId) {
        this.establecimientoMongoRepository.deleteById( establishmentId );
    }
}
