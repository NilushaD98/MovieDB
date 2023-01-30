package com.example.moviedb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActorDTO {

    private int actorNo;
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
