package com.example.moviedb.services.ServiceIMPL;

import com.example.moviedb.dto.ActorDTO;
import com.example.moviedb.dto.paginated.ResponseActorDTO;
import com.example.moviedb.dto.request.RequestAddActorDTO;
import com.example.moviedb.entity.Actor;
import com.example.moviedb.exception.EntityDuplicateException;
import com.example.moviedb.exception.EntityNotFoundException;
import com.example.moviedb.exception.EntityNotUpdateException;
import com.example.moviedb.repo.ActorRepo;
import com.example.moviedb.services.ActorService;
import com.example.moviedb.util.mappers.ActorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceIMPL implements ActorService {

    @Autowired
    private ActorRepo actorRepo;
    @Autowired
    private ActorMapper actorMapper;

    @Override
    public String saveActor(RequestAddActorDTO requestAddActorDTO) {
        Actor actor = actorMapper.DTOTOEntity(requestAddActorDTO);
        if(!actorRepo.existsById(actor.getActorNo())){
            return actorRepo.save(actor).getGivenName()+" saved";
        }else {
            throw new EntityDuplicateException("This actor Already in database");
        }
    }

    @Override
    public ResponseActorDTO getAllActors(int page, int size) {
        Page<Actor> actorPage = actorRepo.findAll(PageRequest.of(page, size));
        return new ResponseActorDTO(
                actorMapper.PageToList(actorPage),
                actorRepo.count()
        );
    }

    @Override
    public String updateActor(ActorDTO requestAddActorDTO) {
        if(actorRepo.existsById(requestAddActorDTO.getActorNo())){
            Actor actor = actorRepo.getById(requestAddActorDTO.getActorNo());
            actor.setBirthCountry(requestAddActorDTO.getBirthCountry());
            actor.setBirthDate(requestAddActorDTO.getBirthDate());
            actor.setFullName(requestAddActorDTO.getFullName());
            actor.setGender(requestAddActorDTO.getGender());
            actor.setGivenName(requestAddActorDTO.getGivenName());
            actor.setSurName(requestAddActorDTO.getSurName());
            actor.setPassword(requestAddActorDTO.getPassword());
            actor.setNoOfDogs(requestAddActorDTO.getNoOfDogs());
            actor.setNoOfCats(requestAddActorDTO.getNoOfCats());
            return actorRepo.save(actor).getGivenName()+" updated";
        }else {
            throw new EntityNotUpdateException("this actor not update");
        }
    }

    @Override
    public String deleteActor(int actor_no) {
        if(actorRepo.existsById(actor_no)){
            String deleteStatus = actorRepo.getById(actor_no).getGivenName();
            actorRepo.deleteById(actor_no);
            return deleteStatus +"deleted";
        }else {
            throw new EntityNotFoundException("this actor not in database");
        }
    }
}
