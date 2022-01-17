package com.example.Movie.service;

import com.example.Movie.entity.Seats;
import com.example.Movie.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;

    public Seats getBySeats(String seats){
        return  seatRepository.getBySeats(seats);
    }
}
