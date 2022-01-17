package com.example.Movie.controller;

import com.example.Movie.entity.Movie;
import com.example.Movie.service.MovieService;
import com.example.Movie.service.MovieShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class MovieController {

    @Autowired
    private MovieShowService movieShowService;
    @Autowired
    private MovieService movieService;

    @GetMapping("/{username}/movie/{movieId}")
    public String movieShow(@PathVariable String username,@PathVariable Long movieId, Model model){
        model.addAttribute("shows", movieShowService.showDetails(movieId));
        model.addAttribute("username", username);
        Movie movie = movieService.getByMovieId(movieId);
        model.addAttribute("movieName", movie.getMovieName());
        model.addAttribute("ratings",movie.getRatings());
        model.addAttribute("genre",movie.getGenre());
        model.addAttribute("duration",movie.getDuration());
        return "movieShow";
    }



}







//
//
//<!--<div class="card-group">-->
//<!--    <div class="col-sm-2">-->
//<!--        <img src="https://in.bmscdn.com/discovery-catalog/events/tr:w-400,h-600,bg-CCCCCC:w-400.0,h-660.0,cm-pad_resize,bg-000000,fo-top:oi-discovery-catalog@@icons@@heart_202006300400.png,ox-24,oy-617,ow-29:ote-ODclICA0MTdrIHZvdGVz,ots-29,otc-FFFFFF,oy-612,ox-70/et00129538-vnxmufqyps-portrait.jpg" class="card-img-top" alt="...">-->
//<!--        <div class="card-body">-->
//<!--            <h5 class="card-title">Pushpa</h5>-->
//<!--            <p class="card-text">UA</p>-->
//<!--            <p class="card-text">Telugu,Tamil,Malayalam</p>-->
//<!--        </div>-->
//<!--    </div>-->
//
//<!--    <div class="col-sm-2">-->
//<!--        <img src="https://in.bmscdn.com/discovery-catalog/events/tr:w-400,h-600,bg-CCCCCC:w-400.0,h-680.0,cm-pad_resize,bg-000000,fo-top:oi-discovery-catalog@@icons@@heart_202006300400.png,ox-24,oy-620,ow-40:ote-ODklICAxMTNrIHZvdGVz,ots-30,otc-FFFFFF,oy-620,ox-80/et00062705-xpmgjnkqam-portrait.jpg" class="card-img-top" alt="...">-->
//<!--        <div class="card-body">-->
//<!--            <h5 class="card-title">83</h5>-->
//<!--            <p class="card-text">U</p>-->
//<!--            <p class="card-text">Hindi,Telugu,Tamil,Kannada</p>-->
//<!--        </div>-->
//<!--    </div>-->
//
//<!--    <div class="col-sm-2">-->
//<!--        <img src="https://in.bmscdn.com/discovery-catalog/events/tr:w-400,h-600,bg-CCCCCC:w-400.0,h-680.0,cm-pad_resize,bg-000000,fo-top:oi-discovery-catalog@@icons@@heart_202006300400.png,ox-24,oy-620,ow-40:ote-OTIlICA0MDlrIHZvdGVz,ots-30,otc-FFFFFF,oy-620,ox-80/et00310790-zwearbqxyz-portrait.jpg" class="card-img-top" alt="...">-->
//<!--        <div class="card-body">-->
//<!--            <h5 class="card-title">Spider-Man: No Way Home</h5>-->
//<!--            <p class="card-text">UA</p>-->
//<!--            <p class="card-text">English,Hindi,Telugu,Tamil</p>-->
//<!--        </div>-->
//<!--    </div>-->
//
