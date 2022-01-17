package com.example.Movie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
public class MovieShow {
    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    private Time time;

    @JsonIgnore
    @ManyToOne
    private Movie movie;

    @OneToMany(mappedBy = "movieShow")
    private List<SeatsBooked> seatsBooked;

//    @OneToMany(mappedBy = "movieShow")
//    private List<Seats> seats;

    public MovieShow(){}

    public MovieShow(Date date, Time time) {
        this.date = date;
        this.time = time;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<SeatsBooked> getSeatsBooked() {
        return seatsBooked;
    }

    public void setSeatsBooked(List<SeatsBooked> seatsBooked) {
        this.seatsBooked = seatsBooked;
    }

//    public List<Seats> getSeats() {
//        return seats;
//    }
//
//    public void setSeats(List<Seats> seats) {
//        this.seats = seats;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
