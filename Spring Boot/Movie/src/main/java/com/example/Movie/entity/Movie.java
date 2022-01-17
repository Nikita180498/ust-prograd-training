package com.example.Movie.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue
    private Long movieId;
    private String movieName;
    private String genre;
    private String ratings;
    private String duration;
    private Date movieReleaseDate;

    @OneToMany(mappedBy = "movie")
    private List<MovieShow> movieShow;

    public Movie(){}

    public Movie(String movieName, String genre,String ratings, String duration,Date movieReleaseDate) {
        this.movieName = movieName;
        this.genre = genre;
        this.ratings = ratings;
        this.duration = duration;
        this.movieReleaseDate = movieReleaseDate;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public void setMovieReleaseDate(Date movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<MovieShow> getMovieShow() {
        return movieShow;
    }

    public void setMovieShow(List<MovieShow> movieShow) {
        this.movieShow = movieShow;
    }
}
