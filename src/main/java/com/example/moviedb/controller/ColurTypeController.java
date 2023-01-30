package com.example.moviedb.controller;

import com.example.moviedb.dto.ColourTypeDTO;
import com.example.moviedb.dto.request.RequestAddColourCodeTypeDTO;
import com.example.moviedb.dto.request.RequestDeleteColourCodeTypeDTO;
import com.example.moviedb.dto.response.ResponseColourType;
import com.example.moviedb.services.ColourTypeService;
import com.example.moviedb.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/vi/colourType/")
public class ColurTypeController {

    @Autowired
    private ColourTypeService colourTypeService;


    @PostMapping(
            path="save_colour_type")
    public ResponseEntity<StandardResponse> saveColourType(@RequestBody RequestAddColourCodeTypeDTO colourTypeDTO){
        String savedStatus = colourTypeService.addColourType(colourTypeDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Saved Colour Type",savedStatus), HttpStatus.OK
        );
    }
    @GetMapping(
            path = {"get_all_colour_types"}
    )
    public ResponseEntity<StandardResponse> getAllColurTypes(){
        List<ResponseColourType> responseColourTypeList = colourTypeService.getAllColourTypes();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"All Colour Types; ",responseColourTypeList),HttpStatus.OK
        );
    }
    @DeleteMapping(
            path = {"delete_colour_type"}
    )
    public ResponseEntity<StandardResponse> deleteColourType(@RequestBody RequestDeleteColourCodeTypeDTO requestDeleteColourCodeTypeDTO){
        String deleteStatus = colourTypeService.deleteColourType(requestDeleteColourCodeTypeDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"colour code delete Status",deleteStatus),HttpStatus.OK
        );
    }

    @PutMapping(
            path = {"update_colour_type"}
    )
    public ResponseEntity<StandardResponse> updateColourType(@RequestBody RequestAddColourCodeTypeDTO requestAddColourCodeTypeDTO){
        String updateStatus = colourTypeService.updateColourType(requestAddColourCodeTypeDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"colour type update status",updateStatus),HttpStatus.OK
        );
    }
}
