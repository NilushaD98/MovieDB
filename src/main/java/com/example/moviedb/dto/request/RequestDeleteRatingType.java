package com.example.moviedb.dto.request;

import com.example.moviedb.entity.enums.RatingCodeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestDeleteRatingType {
    private RatingCodeType ratingCodeType;
}
