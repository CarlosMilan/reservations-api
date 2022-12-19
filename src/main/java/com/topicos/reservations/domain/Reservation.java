package com.topicos.reservations.domain;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class Reservation {
    private String id;

    @NotNull(message = "El id de usuario no puede estar vacío")
    private String userId;

    @NotNull(message = "El id del establecimiento no puede estar vacío")
    private String establishmentId;

    @NotNull(message = "El nombre del establecimiento no puede estar vacío")
    private String establishmentName;

    @NotNull(message = "El nombre de la reserva no puede estar vacía")
    private String name;
    private LocalDateTime reservationDate;

    @NotNull(message = "La cantidad de personas no puede estar vacía")
    @Min(value = 1, message = "La cantidad de personas debe ser al menos 1")
    @Max(value = 20, message = "No se aceptan reservas para más de 20 personas")
    private Integer amountOfPeople;

    @NotNull(message = "La cantidad de mesas no puede estar vacía")
    @Min(value = 1, message = "La cantidad de mesas debe ser al menos 1")
    @Max(value = 4, message = "No se aceptan reservas de más de 4 mesas")
    private Integer numberOfTables;
    private String state;
    private LocalDateTime createAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEstablishmentId() {
        return establishmentId;
    }

    public void setEstablishmentId(String establishmentId) {
        this.establishmentId = establishmentId;
    }

    public String getEstablishmentName() {
        return establishmentName;
    }

    public void setEstablishmentName(String establishmentName) {
        this.establishmentName = establishmentName;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Integer getAmountOfPeople() {
        return amountOfPeople;
    }

    public void setAmountOfPeople(Integer amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }

    public Integer getNumberOfTables() {
        return numberOfTables;
    }

    public void setNumberOfTables(Integer numberOfTables) {
        this.numberOfTables = numberOfTables;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
