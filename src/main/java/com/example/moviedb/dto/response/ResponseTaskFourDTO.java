package com.example.moviedb.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseTaskFourDTO {

    private String title;
    private int movieNo;
    private int runTime;
    private String ratingCode;
    private String shortDesc;

}
