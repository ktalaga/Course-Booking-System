package com.CourseBookingSystem.CourseBookingSystem.controllers;

import com.CourseBookingSystem.CourseBookingSystem.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "bookings")
    public ResponseEntity getAllBookings(){
        return new ResponseEntity(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "bookings/date")
    public ResponseEntity getAllBookingsByDate(
            @RequestParam(name = "bookingDate") String bookingDate
    ){
        return new ResponseEntity(bookingRepository.findByDate(bookingDate), HttpStatus.OK);
    }

}
