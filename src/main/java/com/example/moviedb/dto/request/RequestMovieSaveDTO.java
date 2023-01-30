package com.example.moviedb.dto.request;

import com.example.moviedb.entity.ColourType;
import com.example.moviedb.entity.Rating;
import com.example.moviedb.entity.enums.ColourCodeType;
import com.example.moviedb.entity.enums.RatingCodeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestMovieSaveDTO {

    private int actor;
    private String title;
    private int relYear;
    private int runTime;
    private RatingCodeType ratingCode;
    private ColourCodeType colourCode;
    private double TMDBScore;
    private long TMDBVotes;
    private String IMDBId;
}
