package com.CourseBookingSystem.CourseBookingSystem.controllers;

import com.CourseBookingSystem.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity getAllCustomers(){
        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/course")
    public ResponseEntity getCustomersByCourse(
            @RequestParam(name = "courseName") String courseName
    ){
        return new ResponseEntity(customerRepository.findByBookingsCourseName(courseName), HttpStatus.OK);
    }



}
