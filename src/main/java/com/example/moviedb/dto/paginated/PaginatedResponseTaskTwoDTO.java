package com.example.moviedb.dto.paginated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.moviedb.dto.response.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseTaskTwoDTO {
    private List<ResponseTaskTwoDTO> responseTaskTwoDTOList;
    private long dataCount;
}
