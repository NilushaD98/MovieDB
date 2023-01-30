package com.example.moviedb.services.ServiceIMPL;

import com.example.moviedb.dto.request.RequestAddColourCodeTypeDTO;
import com.example.moviedb.dto.request.RequestDeleteColourCodeTypeDTO;
import com.example.moviedb.dto.response.ResponseColourType;
import com.example.moviedb.entity.ColourType;
import com.example.moviedb.exception.EntityDuplicateException;
import com.example.moviedb.exception.EntityNotFoundException;
import com.example.moviedb.exception.EntityNotUpdateException;
import com.example.moviedb.repo.ColourTypeRepo;
import com.example.moviedb.services.ColourTypeService;
import com.example.moviedb.util.mappers.ColourTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColourTypeServiceIMPL implements ColourTypeService {
    @Autowired
    private ColourTypeRepo colourTypeRepo;

    @Autowired
    private ColourTypeMapper colourTypeMapper;

    @Override
    public String addColourType(RequestAddColourCodeTypeDTO colourTypeDTO) {
        if (!colourTypeRepo.existsById(colourTypeDTO.getColourCode())) {
           return colourTypeRepo.save(colourTypeMapper.DTOTOEntity(colourTypeDTO)).getColourCode() +" saved";
      }else {
            throw new EntityDuplicateException("This Colour Code Already in database");
       }
    }

    @Override
    public List<ResponseColourType> getAllColourTypes() {
        List<ColourType> colourTypeList = colourTypeRepo.findAll();
        List<ResponseColourType> responseColourTypeList = colourTypeMapper.EntityListToDTOList(colourTypeList);
        return responseColourTypeList;
    }

    @Override
    public String deleteColourType(RequestDeleteColourCodeTypeDTO requestDeleteColourCodeTypeDTO) {
        if(colourTypeRepo.existsById(requestDeleteColourCodeTypeDTO.getColourCodeType())){
            String deleteStatus = colourTypeRepo.getById(requestDeleteColourCodeTypeDTO.getColourCodeType())+" deleted";
            colourTypeRepo.deleteById(requestDeleteColourCodeTypeDTO.getColourCodeType());
            return deleteStatus;
        }else {
            throw new EntityNotUpdateException("This colourtype not in database");
        }
    }

    @Override
    public String updateColourType(RequestAddColourCodeTypeDTO requestAddColourCodeTypeDTO) {
        if(colourTypeRepo.existsById(requestAddColourCodeTypeDTO.getColourCode())){
            ColourType colourType = colourTypeRepo.getById(requestAddColourCodeTypeDTO.getColourCode());
            colourType.setColourName(requestAddColourCodeTypeDTO.getColourName());
            colourType.setColourCode(requestAddColourCodeTypeDTO.getColourCode());
            colourTypeRepo.save(colourType);
            return colourType.getColourCode()+" updated";
        }else {
            throw new EntityNotFoundException("This colour type not in database");
        }
    }

}
