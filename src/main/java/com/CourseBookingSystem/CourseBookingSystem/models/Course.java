package com.CourseBookingSystem.CourseBookingSystem.models;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private Long id;
    private String name;
    private String town;
    private int ranting;
    private List<Booking> bookings;

    public Course(String name, String town, int ranting, List<Booking> bookings) {
        this.name = name;
        this.town = town;
        this.ranting = ranting;
        this.bookings = new ArrayList<Booking>();
    }

    public Course() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getRanting() {
        return ranting;
    }

    public void setRanting(int ranting) {
        this.ranting = ranting;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
