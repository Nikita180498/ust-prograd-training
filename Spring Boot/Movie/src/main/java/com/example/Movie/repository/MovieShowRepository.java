package com.example.Movie.repository;

import com.example.Movie.entity.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieShowRepository extends JpaRepository<MovieShow, Long> {
    public List<MovieShow> findByMovieMovieId(Long MovieId);

}
