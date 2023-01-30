package com.example.moviedb.dto.request;

import com.example.moviedb.entity.enums.ColourCodeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestDeleteColourCodeTypeDTO {

    private ColourCodeType colourCodeType;
}
