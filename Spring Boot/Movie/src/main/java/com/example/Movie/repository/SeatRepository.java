package com.example.Movie.repository;

import com.example.Movie.entity.Seats;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SeatRepository extends JpaRepository<Seats, Long> {
    public Seats getBySeats(String seats);
}
