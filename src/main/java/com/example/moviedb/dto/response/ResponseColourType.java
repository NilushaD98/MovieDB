package com.example.moviedb.dto.response;

import com.example.moviedb.entity.enums.ColourCodeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseColourType {
    private ColourCodeType colourCode;
    private String colourName;
}
