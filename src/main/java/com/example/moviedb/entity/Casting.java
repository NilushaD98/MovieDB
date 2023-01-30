package com.example.moviedb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "casting")
public class Casting {

    @Id
    @Column(name = "cast_id",length = 8)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int castID;

    @ManyToOne
    @JoinColumn(name = "actor_no")
    private Actor actorNo;

    @ManyToOne
    @JoinColumn(name = "movie_no")
    private Movie movieNo;

    public Casting(Actor actorNo, Movie movieNo) {
        this.actorNo = actorNo;
        this.movieNo = movieNo;
    }
}
