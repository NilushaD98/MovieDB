package com.example.moviedb.dto.paginated;

import com.example.moviedb.dto.ActorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseActorDTO {
    private List<ActorDTO> actorDTOList;
    private long dataCount;
}
