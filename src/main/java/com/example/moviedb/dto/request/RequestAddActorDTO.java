package com.example.moviedb.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestAddActorDTO {

    private String fullName;
    private String givenName;
    private String surName;
    private String gender;
    private Date birthDate;
    private String birthCountry;
    private String password;
    private int noOfDogs;
    private int noOfCats;
}
