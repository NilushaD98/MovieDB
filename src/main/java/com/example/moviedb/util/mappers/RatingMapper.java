package com.example.moviedb.util.mappers;

import com.example.moviedb.dto.RatingDTO;
import com.example.moviedb.entity.Rating;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RatingMapper {
    Rating RatingEntityToDTO(RatingDTO ratingDTO);
    List<RatingDTO> PageToList(Page<Rating> ratingPage);
}
