package com.example.Movie.repository;

import com.example.Movie.entity.SeatsBooked;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatsBookedRepository extends JpaRepository<SeatsBooked, Long> {

    public boolean existsBySeats(String seat);

    public Boolean existsByMovieShowId(Long id);

    public SeatsBooked getBySeatsAndMovieShowId(String seats, Long id);

    public List<SeatsBooked> findByMovieShowId(Long id);

    public List<SeatsBooked> findByUserUsername(String username);
}
