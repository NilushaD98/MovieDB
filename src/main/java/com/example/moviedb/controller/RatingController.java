package com.example.moviedb.controller;

import com.example.moviedb.dto.RatingDTO;
import com.example.moviedb.dto.paginated.ResponseRatingTypesDTO;
import com.example.moviedb.entity.Rating;
import com.example.moviedb.entity.enums.RatingCodeType;
import com.example.moviedb.services.RatingService;
import com.example.moviedb.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Repository
@CrossOrigin
@RequestMapping("api/v1/rating/")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping(path="save_rating_type")
    public ResponseEntity<StandardResponse> saveRatingType(@RequestBody RatingDTO ratingDTO){
        String ratingTypeSavedStatus = ratingService.saveRatingType(ratingDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"rating type recorded",ratingTypeSavedStatus), HttpStatus.ACCEPTED
        );
    }
    @GetMapping(
            path={"get_all_rating_types"},
            params = {"page","size"}
    )
    public ResponseEntity<StandardResponse> getAllRatingTypes(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ){
        ResponseRatingTypesDTO responseRatingTypesDTO = ratingService.getAllRatingTypes(page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"all rating types",responseRatingTypesDTO),HttpStatus.ACCEPTED
        );
    }
    @DeleteMapping(
            path = {"delete_rating_type"}
    )
    public ResponseEntity<StandardResponse> deleteRatingType(@RequestBody RatingCodeType ratingCodeType){
        String deleteStatus = ratingService.deleteRatingType(ratingCodeType);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"rating code delete status :  ",deleteStatus),HttpStatus.OK
        );
    }
    @PutMapping(
            path = {"update_rating_type"}
    )
    public ResponseEntity<StandardResponse> updateRatingType(@RequestBody RatingDTO ratingDTO){
        String updateStatus= ratingService.updateRatingType(ratingDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Update Status",updateStatus),HttpStatus.OK
        );
    }
}
