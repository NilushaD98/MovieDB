package com.example.moviedb.services.ServiceIMPL;

import com.example.moviedb.dto.RatingDTO;
import com.example.moviedb.dto.paginated.ResponseRatingTypesDTO;
import com.example.moviedb.entity.Rating;
import com.example.moviedb.entity.enums.RatingCodeType;
import com.example.moviedb.exception.EntityDuplicateException;
import com.example.moviedb.exception.EntityNotFoundException;
import com.example.moviedb.exception.EntityNotUpdateException;
import com.example.moviedb.repo.RatingRepo;
import com.example.moviedb.services.RatingService;
import com.example.moviedb.util.mappers.RatingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceIMPL implements RatingService {
    @Autowired
    private RatingRepo ratingRepo;
    @Autowired
    private RatingMapper ratingMapper;
    @Override
    public String saveRatingType(RatingDTO ratingDTO) {
        if(!ratingRepo.existsById(ratingDTO.getRatingCodeType())){
            Rating rating = ratingMapper.RatingEntityToDTO(ratingDTO);
           return ratingRepo.save(rating).getRatingCodeType()+" Saved";
        }else{
            throw new EntityDuplicateException("This Rating type Already in database");
        }
    }
    @Override
    public ResponseRatingTypesDTO getAllRatingTypes(int page, int size) {
        Page<Rating> ratingPage = ratingRepo.findAll(PageRequest.of(page,size));
        return new ResponseRatingTypesDTO(
                ratingMapper.PageToList(ratingPage),
                ratingRepo.count()
        );
    }
    @Override
    public String deleteRatingType(Enum<RatingCodeType> ratingCodeTypeEnum) {
        if(ratingRepo.existsById(ratingCodeTypeEnum)){
            String status = ratingRepo.getById(ratingCodeTypeEnum).toString();
            ratingRepo.deleteById(ratingCodeTypeEnum);
            return status+" deleted";
        }else {
            throw new EntityNotFoundException("This rating type not in database");
        }
    }
    @Override
    public String updateRatingType(RatingDTO ratingDTO) {
        if(ratingRepo.existsById(ratingDTO.getRatingCodeType())){
            Rating rating = ratingRepo.getById(ratingDTO.getRatingCodeType());
            rating.setShortDesc(ratingDTO.getShortDesc());
            rating.setLongDesc(ratingDTO.getLongDesc());
            return ratingRepo.save(rating).getRatingCodeType()+" updated";

        }else {
            throw new EntityNotUpdateException("update process unsuccessful");
        }
    }
}
