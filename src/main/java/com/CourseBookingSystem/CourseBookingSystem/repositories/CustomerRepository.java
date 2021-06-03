package com.CourseBookingSystem.CourseBookingSystem.repositories;

import com.CourseBookingSystem.CourseBookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    List<Customer> findByBookingsCourseNameIgnoreCase(String courseName);

    List<Customer> findByBookingsCourseNameAndBookingsCourseTownIgnoreCase(String courseName, String townName);

    List<Customer> findByAgeGreaterThanAndBookingsCourseNameAndBookingsCourseTownIgnoreCase(int age, String courseName, String townName);
}
