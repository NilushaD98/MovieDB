package com.example.moviedb.util.mappers;

import com.example.moviedb.dto.ActorDTO;
import com.example.moviedb.dto.request.RequestAddActorDTO;
import com.example.moviedb.entity.Actor;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActorMapper {
    Actor DTOTOEntity(RequestAddActorDTO requestAddActorDTO);

    List<ActorDTO> PageToList(Page<Actor> actorPage);
}
