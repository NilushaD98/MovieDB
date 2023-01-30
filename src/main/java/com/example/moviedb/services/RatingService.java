package com.example.moviedb.services;

import com.example.moviedb.dto.RatingDTO;
import com.example.moviedb.dto.paginated.ResponseRatingTypesDTO;
import com.example.moviedb.entity.enums.RatingCodeType;

public interface RatingService {
    String saveRatingType(RatingDTO ratingDTO);

    ResponseRatingTypesDTO getAllRatingTypes(int page, int size);

    String deleteRatingType(Enum<RatingCodeType> ratingCodeTypeEnum);

    String updateRatingType(RatingDTO ratingDTO);
}
