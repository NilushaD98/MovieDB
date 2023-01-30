package com.example.moviedb.repo;

import com.example.moviedb.dto.Queryinterfaces.TaskFourInterface;
import com.example.moviedb.dto.Queryinterfaces.TaskOneInterFace;
import com.example.moviedb.dto.Queryinterfaces.TaskThreeInterface;
import com.example.moviedb.dto.Queryinterfaces.TaskTwoInterface;
import com.example.moviedb.entity.Movie;
import com.example.moviedb.entity.enums.RatingCodeType;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;

@EnableJpaRepositories
@Repository
@Transactional
public interface MovieRepo extends JpaRepository<Movie,Integer> {
    @Query(value = "SELECT  movie_no, title, rel_year FROM movie ORDER BY movie_no DESC ",nativeQuery = true)
    List<TaskOneInterFace> getTaskOneData(PageRequest of);

    @Query(value = "SELECT title, rel_year, colour_code, rating_code FROM Movie WHERE rating_code=?1 ORDER BY rel_year ASC , title ASC ",nativeQuery = true)
    List<TaskTwoInterface> getTaskTwoData(String ratingCode,PageRequest of);
    @Query(value = "SELECT movie_no, title, rel_year, run_time, rating_code, colour_code, tmdb_score, tmdb_votes, imdb_id FROM Movie WHERE (TMDB_SCORE>=?1 AND rel_year<=?2) ORDER BY movie_no ASC",nativeQuery = true)
    List<TaskThreeInterface> getTaskThreeData(double tmdb_score_bound, int rel_year_bound, PageRequest of);

    @Query(value = "SELECT  movie.title, movie.movie_no, movie.run_time, movie.rating_code,rating.short_desc FROM movie INNER JOIN rating ON rating.rating_code=movie.rating_code WHERE movie.rel_year>=?1 AND movie.run_time<=?2 ORDER BY movie_no ASC",nativeQuery = true)
    List<TaskFourInterface> getTaskFourData(int rel_year, int run_time, PageRequest of);
}
