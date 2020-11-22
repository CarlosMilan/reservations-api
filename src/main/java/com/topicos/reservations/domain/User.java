package com.topicos.reservations.domain;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private String id;
    private String name;
    private String lastName;
    private Address address;
    private String email;
    private List<String> phones;
    private List<String> reservations;
}
