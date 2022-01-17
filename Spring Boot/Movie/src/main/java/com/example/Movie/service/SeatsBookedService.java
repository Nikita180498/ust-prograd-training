package com.example.Movie.service;

import com.example.Movie.entity.SeatsBooked;
import com.example.Movie.repository.SeatsBookedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatsBookedService {

    @Autowired
    private SeatsBookedRepository seatsBookedRepository;

    public SeatsBooked saveSeat(SeatsBooked seatsBooked) {

        return seatsBookedRepository.save(seatsBooked);
    }

    public Boolean existsBySeats(String seats) {
        return seatsBookedRepository.existsBySeats(seats);
    }

    public Boolean existsByMovieShowId(Long movieShowId){
        return seatsBookedRepository.existsByMovieShowId(movieShowId);
    }

    public SeatsBooked getBySeatsAndMovieShowId(String seats, Long id){
        return seatsBookedRepository.getBySeatsAndMovieShowId(seats,id);
    }
    public List<SeatsBooked> findByShowId(Long id){
        return seatsBookedRepository.findByMovieShowId(id);
    }

    public List<SeatsBooked> bookedList(){
        return seatsBookedRepository.findAll();
    }


    public List<SeatsBooked> findByUserUsername(String username) {
        return seatsBookedRepository.findByUserUsername(username);
    }
}
