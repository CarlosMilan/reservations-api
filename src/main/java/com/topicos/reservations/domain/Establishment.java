package com.topicos.reservations.domain;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class Establishment {

    private String id;

    @NotNull(message = "El nombre no puede estar vacío")
    private String name;

    @NotNull(message = "El tipo de establecimiento no puede estar vacío")
    private String type;

    @NotNull(message = "La dirección del establecimiento no puede estar vacío")
    private Address address;
    private List<@NotNull(message = "El numero de telefono no puede estar vacío") String> phones;

    @NotNull
    @Min(value = 5, message = "La capacidad máxima no puede ser infrior a 5 personas")
    @Max(value = 1000, message = "La capacidad máxima no puede ser mayor a 1000 personas")
    private Integer maxCapacity;
    private Double rating;
    private Integer numOfVotes;
    private Location location;
    private List<Review> reviews;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getNumOfVotes() {
        return numOfVotes;
    }

    public void setNumOfVotes(Integer numOfVotes) {
        this.numOfVotes = numOfVotes;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
