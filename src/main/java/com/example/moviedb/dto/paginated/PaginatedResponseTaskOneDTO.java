package com.example.moviedb.dto.paginated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseTaskOneDTO {
    private List<com.example.moviedb.dto.response.ResponseTaskOneDTO> responseTaskOneDTOList;
    private long dataCount;
}
