package com.example.moviedb.dto.paginated;

import com.example.moviedb.dto.RatingDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseRatingTypesDTO {
    private List<RatingDTO> ratingDTOList;
    private long dataCount;
}
