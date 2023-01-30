package com.example.moviedb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "actor_no",length = 8)
    private int actorNo;

    @Column(name = "full_name",length = 100)
    private String fullName;
    @Column(name = "fiven_name",length = 100)
    private String givenName;

    @Column(name = "sur_name",length = 100)
    private String surName;

    @Column(name="gender",length = 1)
    private String gender;

    @Column(name = "birth_date",columnDefinition = "DATETIME")
    private Date birthDate;

    @Column(name="birth_country",length = 50)
    private String birthCountry;

    @Column(name = "password",length = 6)
    private String password;

    @Column(name = "no_of_dogs",length = 2)
    private int noOfDogs;

    @Column(name = "no_of_cats",length = 2)
    private int noOfCats;

    @OneToMany(mappedBy = "actorNo")
    private Set<Casting> castingSet;

    public Actor(String fullName, String givenName, String surName, String gender, Date birthDate, String birthCountry, String password, int noOfDogs, int noOfCats) {
        this.fullName = fullName;
        this.givenName = givenName;
        this.surName = surName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.birthCountry = birthCountry;
        this.password = password;
        this.noOfDogs = noOfDogs;
        this.noOfCats = noOfCats;
    }
}
