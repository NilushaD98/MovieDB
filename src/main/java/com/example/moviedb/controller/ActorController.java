package com.example.moviedb.controller;

import com.example.moviedb.dto.ActorDTO;
import com.example.moviedb.dto.paginated.ResponseActorDTO;
import com.example.moviedb.dto.request.RequestAddActorDTO;
import com.example.moviedb.services.ActorService;
import com.example.moviedb.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/actor/")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @PostMapping(
            path = {"save_actor"}
    )
    public ResponseEntity<StandardResponse> saveActor(@RequestBody RequestAddActorDTO requestAddActorDTO) {
        String actorSaveStatus = actorService.saveActor(requestAddActorDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Actor Saved", actorSaveStatus), HttpStatus.OK
        );
    }

    @GetMapping(
            path = {"get_all_actors"},
            params = {"page", "size"}
    )
    public ResponseEntity<StandardResponse> getAllActors(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        ResponseActorDTO responseActorDTO = actorService.getAllActors(page, size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "All actors.", responseActorDTO), HttpStatus.OK
        );
    }

    @PutMapping(
            path = {"update_actor"}
    )
    public ResponseEntity<StandardResponse> updateActor(@RequestBody ActorDTO requestAddActorDTO) {
        String updateStatus = actorService.updateActor(requestAddActorDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Actor update status : ", updateStatus), HttpStatus.OK
        );
    }

    @DeleteMapping(
            path = {"delete_actor"},
            params = {"actor_no"}

    )
    public ResponseEntity<StandardResponse> deleteActor(@RequestParam(value = "actor_no") int actor_no) {
        String deleteStatus = actorService.deleteActor(actor_no);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"actor delete Status: ",deleteStatus),HttpStatus.OK
        );
    }
}
