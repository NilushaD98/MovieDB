package com.example.moviedb.services;

import com.example.moviedb.dto.ColourTypeDTO;
import com.example.moviedb.dto.request.RequestAddColourCodeTypeDTO;
import com.example.moviedb.dto.request.RequestDeleteColourCodeTypeDTO;
import com.example.moviedb.dto.response.ResponseColourType;

import java.util.List;

public interface ColourTypeService {

    String addColourType(RequestAddColourCodeTypeDTO colourTypeDTO);

    List<ResponseColourType> getAllColourTypes();

    String deleteColourType(RequestDeleteColourCodeTypeDTO requestDeleteColourCodeTypeDTO);

    String updateColourType(RequestAddColourCodeTypeDTO requestAddColourCodeTypeDTO);
}
