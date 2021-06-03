package com.CourseBookingSystem.CourseBookingSystem.controllers;

import com.CourseBookingSystem.CourseBookingSystem.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity getAllCourses(){
        return new ResponseEntity(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/rating")
    public ResponseEntity getCoursesByRating(
            @RequestParam(name = "rating") int rating
    ){
        return new ResponseEntity(courseRepository.findByRating(rating), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/customer")
    public ResponseEntity getCoursesByCustomerName(
            @RequestParam(name = "customerName") String customerName
    ){
        return new ResponseEntity(courseRepository.findByBookingsCustomerNameIgnoreCase(customerName), HttpStatus.OK);
    }

}
