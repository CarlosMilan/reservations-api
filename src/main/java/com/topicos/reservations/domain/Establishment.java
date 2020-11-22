package com.topicos.reservations.domain;

import lombok.Data;

import java.util.List;

@Data
public class Establishment {

    private String id;
    private String name;
    private String type;
    private Address address;
    private Integer maxCapacity;
    private Double rating;
    private Integer numOfVotes;
    private Location location;
    private List<Review> reviews;
}
