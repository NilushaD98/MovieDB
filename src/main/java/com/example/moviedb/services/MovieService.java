package com.example.moviedb.services;

import com.example.moviedb.dto.paginated.PaginatedResponseTaskFourDTO;
import com.example.moviedb.dto.paginated.PaginatedResponseTaskOneDTO;
import com.example.moviedb.dto.paginated.PaginatedResponseTaskThreeDTO;
import com.example.moviedb.dto.paginated.PaginatedResponseTaskTwoDTO;
import com.example.moviedb.dto.request.RequestMovieSaveDTO;
import com.example.moviedb.entity.enums.RatingCodeType;

public interface MovieService {
    String saveMovie(RequestMovieSaveDTO requestMovieSaveDTO);

    PaginatedResponseTaskOneDTO taskOne(int page, int size);

    PaginatedResponseTaskTwoDTO taskTwo(String ratingCode,int page, int size);

    PaginatedResponseTaskThreeDTO taskThree(double tmdb_score_bound, int rel_year_bound, int page, int size);

    PaginatedResponseTaskFourDTO taskFour(int page, int size, int rel_year, int run_time);
}
