package com.example.Movie.controller;

import com.example.Movie.entity.User;
import com.example.Movie.service.MovieService;
import com.example.Movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;

    //Home Page
    @RequestMapping("/")
    public String home(){
        return "Home";
    }

    //Login Page
    @RequestMapping("/login")
    public String loginForm(){
        return "login";
    }


    //Registration Page
    @RequestMapping("/registration")
    public String registrationForm() {
        return "registration";
    }

    @PostMapping("/login")
    public String registration(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        String address = request.getParameter("address");

        User user = new User(username,password,name,email,contact,address);
        userService.save(user);
        return "login";
    }


    @GetMapping("/movies")
    public String movies(){
        return "movies";
    }

    @PostMapping("/movies")
    public String login(Model model, HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user;
        if (userService.existsById(username) == true) {
            user = userService.findUserByUsername(username);
            if (password.equals(user.getPassword())) {
                model.addAttribute("username", username);
                model.addAttribute("movies", movieService.movieList() );

            } else {
                model.addAttribute("message", "Incorrect Password.");
                return "login";
            }
        } else {
            model.addAttribute("errorMessage", "Please enter valid Username");
            return "login";
        }
        return "movies";
    }

    @RequestMapping("/userDetails/{id}")
    public String userDetails(@PathVariable String id, Model model){
        model.addAttribute("username",(id));
        User user = userService.findUserByUsername(id);
        model.addAttribute("password",user.getPassword());
        model.addAttribute("name",user.getName());
        model.addAttribute("contact",user.getContact());
        model.addAttribute("email",user.getEmail());
        model.addAttribute("address",user.getAddress());

        return "userDetails";
    }


    @RequestMapping("/updateDetails/{id}")
    public String updateDetailsForm(@PathVariable String id, Model model){
        model.addAttribute("user",userService.findUserByUsername(id));
        return "updateDetails";
    }

    @PostMapping("/updateDetails")
    public String updateDetails(Model model,HttpServletRequest request){

        User existingUser = userService.findUserByUsername(request.getParameter("username"));
        existingUser.setPassword(request.getParameter("password"));
        existingUser.setName(request.getParameter("name"));
        existingUser.setContact(request.getParameter("contact"));
        existingUser.setEmail(request.getParameter("email"));
        existingUser.setAddress(request.getParameter("address"));

        userService.updateUser(existingUser);

        model.addAttribute("name", existingUser.getName());
        model.addAttribute("username", existingUser.getUsername());
        model.addAttribute("password",existingUser.getPassword());
        model.addAttribute("email", existingUser.getEmail());
        model.addAttribute("address", existingUser.getAddress());
        model.addAttribute("contact", existingUser.getContact());

        model.addAttribute("message", "Updated successfully");

        return "userDetails";
    }


}
