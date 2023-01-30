package com.example.moviedb.dto;

import com.example.moviedb.entity.Movie;
import com.example.moviedb.entity.enums.RatingCodeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RatingDTO {

    private RatingCodeType ratingCodeType;
    private String shortDesc;
    private String longDesc;

}
