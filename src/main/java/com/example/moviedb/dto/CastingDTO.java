package com.example.moviedb.dto;

import com.example.moviedb.entity.Actor;
import com.example.moviedb.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CastingDTO {

    private int castID;
    private Actor actorNo;
    private Movie movieNo;

    public CastingDTO(Actor actorNo, Movie movieNo) {
        this.actorNo = actorNo;
        this.movieNo = movieNo;
    }
}
