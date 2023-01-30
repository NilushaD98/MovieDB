package com.example.moviedb.dto.response;

import com.example.moviedb.entity.ColourType;
import com.example.moviedb.entity.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseTaskTwoDTO {

    private String title;
    private int relYear;
    private String ratingCode;
    private String colourCode;

}
