package com.example.moviedb.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseTaskOneDTO {

    private int movieNo;
    private String title;
    private int relYear;

}
