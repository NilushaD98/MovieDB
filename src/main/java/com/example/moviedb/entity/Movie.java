package com.example.moviedb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_no",length = 8)
    private int movieNo;

    @Column(name = "title",length = 100)
    private String title;

    @Column(name = "rel_year",length = 4)
    private int relYear;

    @Column(name="run_time",length = 4)
    private int runTime;
    @ManyToOne
    @JoinColumn(name = "rating_code")
    private Rating ratingCode;
    @ManyToOne
    @JoinColumn(name = "colour_code")
    private ColourType colourCode;

    @Column(name = "TMDB_score")
    private double TMDBScore;

    @Column(name = "TMDB_votes")
    private long TMDBVotes;

    @Column(name = "IMDB_id")
    private String IMDBId;

    @OneToMany(mappedBy = "movieNo")
    private Set<Casting> castingSet;

    public Movie(String title, int relYear, int runTime, Rating ratingCode, ColourType colourCode, double TMDBScore, long TMDBVotes, String IMDBId) {
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
