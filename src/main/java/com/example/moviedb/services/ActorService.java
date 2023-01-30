package com.example.moviedb.services;

import com.example.moviedb.dto.ActorDTO;
import com.example.moviedb.dto.paginated.ResponseActorDTO;
import com.example.moviedb.dto.request.RequestAddActorDTO;

public interface ActorService {
    String saveActor(RequestAddActorDTO requestAddActorDTO);

    ResponseActorDTO getAllActors(int page, int size);

    String updateActor(ActorDTO requestAddActorDTO);

    String deleteActor(int actor_no);
}
