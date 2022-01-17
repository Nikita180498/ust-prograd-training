package com.example.Movie.service;

import com.example.Movie.entity.MovieShow;
import com.example.Movie.repository.MovieShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieShowService {
    @Autowired
    private MovieShowRepository movieShowRepository;

    public List<MovieShow> showDetails(Long movieId){
        return movieShowRepository.findByMovieMovieId(movieId);
    }

    public List<MovieShow> showList(){
        return movieShowRepository.findAll();
    }

    public MovieShow getById(Long id){
        return movieShowRepository.getById(id);
    }

    public boolean existsById(Long id) {
        return movieShowRepository.existsById(id);
    }
}
