package com.topicos.reservations.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Review {
    private  String userId;
    private Integer score;
    private String commentary;
    private Date createAt;
}
