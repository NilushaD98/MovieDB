package com.example.moviedb.dto.paginated;
import com.example.moviedb.dto.response.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseTaskFourDTO {
    private List<ResponseTaskFourDTO>  responseTaskFourDTOList;
    private long dataCount;

}
