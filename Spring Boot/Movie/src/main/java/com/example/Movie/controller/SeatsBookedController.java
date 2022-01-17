package com.example.Movie.controller;

import com.example.Movie.entity.Movie;
import com.example.Movie.entity.Seats;
import com.example.Movie.entity.SeatsBooked;
import com.example.Movie.service.MovieShowService;
import com.example.Movie.service.SeatService;
import com.example.Movie.service.SeatsBookedService;
import com.example.Movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
public class SeatsBookedController {

    @Autowired
    private UserService userService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private SeatsBookedService seatsBookedService;

    @Autowired
    private MovieShowService movieShowService;

    @GetMapping("/{username}/seats/{id}")
    public String seats(@PathVariable String username, @PathVariable Long id, Model model){
        model.addAttribute("shows",id);
        model.addAttribute("username", username);
        return "seats";
    }

    @GetMapping("/{username}/booked/{shows}")
    public String booked(@PathVariable String username, @PathVariable Long shows, Model model){
        model.addAttribute("username",username);
        model.addAttribute("shows",shows);
        return "booked";
    }

    @PostMapping("/{username}/booked/{shows}")
    public String seatBooked(@PathVariable String username, @PathVariable Long shows,HttpServletRequest servletRequest, Model model){
        String seatsBook = servletRequest.getParameter("seatsBooked");
        String[] seatBooked = seatsBook.split(",");
        for(String seat : seatBooked){
            SeatsBooked seatsBooked = seatsBookedService.getBySeatsAndMovieShowId(seat,shows);
            if (!(Objects.isNull(seatsBooked))){
                model.addAttribute( "message",seatsBook + "Seat is already booked.. choose another...");
                return "seats";
            }
        }
        for (String seat : seatBooked){
            Seats seats = seatService.getBySeats(seat);
            SeatsBooked seatsBooked = new SeatsBooked(seats.getSeats(),seats.getPrice());
            seatsBooked.setMovieShow(movieShowService.getById(shows));
            seatsBooked.setUser(userService.findUserByUsername(username));
            seatsBookedService.saveSeat(seatsBooked);
        }
        return "booked";

    }

    @GetMapping("/{username}/myBookings")
    public String myBookings(@PathVariable String username, Model model){
        model.addAttribute("username",seatsBookedService.findByUserUsername(username));
        return "myBookings";
    }

}
