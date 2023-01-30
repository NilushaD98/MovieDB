package com.example.moviedb.services.ServiceIMPL;

import com.example.moviedb.dto.Queryinterfaces.*;
import com.example.moviedb.dto.paginated.PaginatedResponseTaskFourDTO;
import com.example.moviedb.dto.paginated.PaginatedResponseTaskOneDTO;
import com.example.moviedb.dto.paginated.PaginatedResponseTaskThreeDTO;
import com.example.moviedb.dto.paginated.PaginatedResponseTaskTwoDTO;
import com.example.moviedb.exception.*;
import com.example.moviedb.dto.request.RequestMovieSaveDTO;
import com.example.moviedb.dto.response.*;
import com.example.moviedb.entity.Casting;
import com.example.moviedb.entity.Movie;
import com.example.moviedb.entity.enums.RatingCodeType;
import com.example.moviedb.exception.EntityNotFoundException;
import com.example.moviedb.repo.*;
import com.example.moviedb.services.MovieService;
import com.example.moviedb.util.mappers.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MovieServiceIMPL implements MovieService {

    @Autowired
    private MovieRepo movieRepo;
    @Autowired
    private ColourTypeRepo colourTypeRepo;
    @Autowired
    private RatingRepo ratingRepo;
    @Autowired
    private ActorRepo actorRepo;
    @Autowired
    private CastingRepo castingRepo;
    @Autowired
    private MovieMapper movieMapper;


    @Override
    public String saveMovie(RequestMovieSaveDTO requestMovieSaveDTO) {

        Movie movie = new Movie(
                requestMovieSaveDTO.getTitle(),
                requestMovieSaveDTO.getRelYear(),
                requestMovieSaveDTO.getRunTime(),
                ratingRepo.getById(requestMovieSaveDTO.getRatingCode()),
                colourTypeRepo.getById(requestMovieSaveDTO.getColourCode()),
                requestMovieSaveDTO.getTMDBScore(),
                requestMovieSaveDTO.getTMDBVotes(),
                requestMovieSaveDTO.getIMDBId()
        );
        movieRepo.save(movie);
        if(actorRepo.existsById(requestMovieSaveDTO.getActor())){
            if(movieRepo.existsById(movie.getMovieNo())){
                Casting casting = new Casting(
                        actorRepo.getById(requestMovieSaveDTO.getActor()),
                        movieRepo.getById(movie.getMovieNo())
                );
                return castingRepo.save(casting).getCastID() + " and "+movie.getTitle()+" saved.";
            }else{
                throw new EntityNotFoundException("movie not in database");
            }
        }else {
            throw new EntityNotFoundException("actor not in database");
        }
    }

    @Override
    public PaginatedResponseTaskOneDTO taskOne(int page, int size) {
        List<TaskOneInterFace> taskOneInterFacesList = movieRepo.getTaskOneData(PageRequest.of(page,size));

        List<ResponseTaskOneDTO> responseTaskOneDTOList = new ArrayList<>();
        for(TaskOneInterFace t: taskOneInterFacesList){
            responseTaskOneDTOList.add(
                    new ResponseTaskOneDTO(
                            t.getMovie_No(),t.getTitle(),t.getRel_Year()
                    )
            );

        }
        return new PaginatedResponseTaskOneDTO(
                responseTaskOneDTOList,
                movieRepo.count()
        );
    }

    @Override
    public PaginatedResponseTaskTwoDTO taskTwo(String ratingCode,int page, int size) {

        if(ratingCode.equalsIgnoreCase("g")||
                ratingCode.equalsIgnoreCase("m") ||
                ratingCode.equalsIgnoreCase("ma") ||
                ratingCode.equalsIgnoreCase("pg") ||
                ratingCode.equalsIgnoreCase("r") ||
                ratingCode.equalsIgnoreCase("h")

        ){
            List<TaskTwoInterface> taskTwoInterfaceList = movieRepo.getTaskTwoData(ratingCode,PageRequest.of(page, size));
            List<ResponseTaskTwoDTO> responseTaskTwoDTOList = new ArrayList<>();
            for (TaskTwoInterface t:taskTwoInterfaceList){
                responseTaskTwoDTOList.add(
                        new ResponseTaskTwoDTO(
                                t.getTitle(),t.getRel_Year(),t.getRating_Code(),t.getColour_Code()
                        )
                );
            }
            return new PaginatedResponseTaskTwoDTO(
                    responseTaskTwoDTOList,
                    responseTaskTwoDTOList.size()
            );
        }
        else {
            throw new EnumTypeWrongException("Enum type wrong");
        }
    }

    @Override
    public PaginatedResponseTaskThreeDTO taskThree(double tmdb_score_bound, int rel_year_bound,int page, int size) {
        List<TaskThreeInterface> taskThreeInterfaceList = movieRepo.getTaskThreeData(tmdb_score_bound,rel_year_bound,PageRequest.of(page, size));
        List<ResponseTaskThreeDTO> responseTaskThreeDTOList = new ArrayList<>();
        for (TaskThreeInterface t: taskThreeInterfaceList) {
            responseTaskThreeDTOList.add(
                    new ResponseTaskThreeDTO(
                            t.getMovie_no(),t.getTitle(),t.getRel_year(),t.getRun_time(),t.getRating_code(),t.getColour_Code(),t.getTmdb_score(),t.getTmdb_votes(),t.getImdb_id()
                    )
            );
        }
        return new PaginatedResponseTaskThreeDTO(
                responseTaskThreeDTOList,
                responseTaskThreeDTOList.size()
        );
    }

    @Override
    public PaginatedResponseTaskFourDTO taskFour(int page, int size, int rel_year, int run_time) {
        List<TaskFourInterface> taskFourInterfaceList = movieRepo.getTaskFourData(rel_year,run_time,PageRequest.of(page, size));
        List<ResponseTaskFourDTO> responseTaskFourDTOList = new ArrayList<>();
        for (TaskFourInterface t: taskFourInterfaceList
             ) {
            responseTaskFourDTOList.add(
                    new ResponseTaskFourDTO(
                            t.getTitle(),t.getMovie_No(),t.getRun_Time(),t.getRating_Code(),t.getShort_Desc()
                    )
            );
        }
        return new PaginatedResponseTaskFourDTO(
                responseTaskFourDTOList,
                movieRepo.count()
        );
    }

}

