package com.example.Movie.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    private String username;
    private String password;
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String contact;
    private String address;

    @OneToMany(mappedBy = "user")
    private List<SeatsBooked> seatsBooked;

    public User(){}

    public User(String username, String password, String name,String email,String contact,String address){
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.address = address;
    }


    public List<SeatsBooked> getSeatsBooked() {
        return seatsBooked;
    }

    public void setSeatsBooked(List<SeatsBooked> seatsBooked) {
        this.seatsBooked = seatsBooked;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
