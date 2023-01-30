package com.example.moviedb.dto.request;

import com.example.moviedb.entity.Movie;
import com.example.moviedb.entity.enums.ColourCodeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestAddColourCodeTypeDTO {
    private ColourCodeType colourCode;
    private String colourName;
}
