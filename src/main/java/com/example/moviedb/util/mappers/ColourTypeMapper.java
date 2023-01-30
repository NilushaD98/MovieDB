package com.example.moviedb.util.mappers;

import com.example.moviedb.dto.ColourTypeDTO;
import com.example.moviedb.dto.request.RequestAddColourCodeTypeDTO;
import com.example.moviedb.dto.response.ResponseColourType;
import com.example.moviedb.entity.ColourType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColourTypeMapper {

    ColourType DTOTOEntity(RequestAddColourCodeTypeDTO colourTypeDTO);

    List<ResponseColourType> EntityListToDTOList(List<ColourType> colourTypeList);
}
