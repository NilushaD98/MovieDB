package com.example.moviedb.dto;

import com.example.moviedb.entity.ColourType;
import com.example.moviedb.entity.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieDTO {

    private int movieNo;
    private String title;
    private int relYear;
    private int runTime;
    private Rating ratingCode;
    private ColourType colourCode;
    private double TMDBScore;
    private long TMDBVotes;
    private String IMDBId;

    public MovieDTO(String title, int relYear, int runTime, Rating ratingCode, ColourType colourCode, double TMDBScore, long TMDBVotes, String IMDBId) {
        this.title = title;
        this.relYear = relYear;
        this.runTime = runTime;
        this.ratingCode = ratingCode;
        this.colourCode = colourCode;
        this.TMDBScore = TMDBScore;
        this.TMDBVotes = TMDBVotes;
        this.IMDBId = IMDBId;
    }
}
