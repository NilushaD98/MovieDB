package com.example.moviedb.controller;

import com.example.moviedb.dto.paginated.*;
import com.example.moviedb.dto.request.*;
import com.example.moviedb.entity.enums.RatingCodeType;
import com.example.moviedb.services.*;
import com.example.moviedb.services.ServiceIMPL.*;
import com.example.moviedb.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

@RestController
@CrossOrigin
@RequestMapping("api/v1/movie/")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private EmailServiceIMPL emailServiceIMPL;

    @PostMapping(
            path = {"movie_save"}
    )
    public ResponseEntity<StandardResponse> movieSave(@RequestBody RequestMovieSaveDTO requestMovieSaveDTO){
    String movieSaveStatus = movieService.saveMovie(requestMovieSaveDTO);
    return new ResponseEntity<StandardResponse>(
            new StandardResponse(200,"movie save status:",movieSaveStatus), HttpStatus.OK
    );
    }
    @GetMapping(
            path={"task_one"},
            params = {"page","size"}
    )
    public ResponseEntity<StandardResponse> taskOne(
            @RequestParam(value = "page")int page,
            @RequestParam(value = "size")@Max(50) int size)
    {
        PaginatedResponseTaskOneDTO paginatedResponseTaskOneDTOPage = movieService.taskOne(page,size);
        emailServiceIMPL.mailSender(
                "anjanaheshanthach@gmail.com",
                "this is subject",
                paginatedResponseTaskOneDTOPage.toString()
        );
        return new ResponseEntity<>(
                new StandardResponse(200,"Task One Data", paginatedResponseTaskOneDTOPage),HttpStatus.ACCEPTED
        );
    }
    @GetMapping(
            path = {"task_two"},
            params={"page","size","ratingCode"}
    )
    public ResponseEntity<StandardResponse> taskTwo(
            @RequestParam(value = "page")int page,
            @RequestParam(value = "size")@Max(50) int size,
            @RequestParam(value = "ratingCode")String ratingCode
    )
    {
        PaginatedResponseTaskTwoDTO paginatedResponseTaskTwoDTOpage = movieService.taskTwo(ratingCode,page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Task two data: ",paginatedResponseTaskTwoDTOpage),HttpStatus.OK
        );
    }
    @GetMapping(
            path = {"task_three"},
            params = {"page","size","tmdb_score_bound","rel_year_bound"}
    )
    public ResponseEntity<StandardResponse> taskThree(
            @RequestParam(value = "tmdb_score_bound") double tmdb_score_bound,
            @RequestParam(value = "rel_year_bound") int rel_year_bound,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size

    ){
        PaginatedResponseTaskThreeDTO paginatedResponseTaskThreeDTO = movieService.taskThree(tmdb_score_bound,rel_year_bound,page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Task Three Data; ",paginatedResponseTaskThreeDTO),HttpStatus.ACCEPTED
        );
    }
    @GetMapping(
            path = {"task_four"},
            params = {"rel_year_condition","run_time_condition","page","size"}
    )
    public ResponseEntity<StandardResponse> taskFour(
            @RequestParam(value = "rel_year_condition") int rel_year,
            @RequestParam(value = "run_time_condition") int run_time,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ){
        PaginatedResponseTaskFourDTO paginatedResponseTaskFourDTO  = movieService.taskFour(page,size,rel_year,run_time);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Task Four Data:",paginatedResponseTaskFourDTO),HttpStatus.OK
        );
    }
}
