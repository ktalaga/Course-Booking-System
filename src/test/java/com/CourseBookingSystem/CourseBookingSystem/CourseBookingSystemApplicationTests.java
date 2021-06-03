package com.CourseBookingSystem.CourseBookingSystem;

import com.CourseBookingSystem.CourseBookingSystem.models.Booking;
import com.CourseBookingSystem.CourseBookingSystem.models.Course;
import com.CourseBookingSystem.CourseBookingSystem.models.Customer;
import com.CourseBookingSystem.CourseBookingSystem.repositories.BookingRepository;
import com.CourseBookingSystem.CourseBookingSystem.repositories.CourseRepository;
import com.CourseBookingSystem.CourseBookingSystem.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class CourseBookingSystemApplicationTests {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void canGetAllCoursesWithRating() {
		List<Course> extractedCourses = courseRepository.findByRating(6);
		assertEquals(1, extractedCourses.size());
	}

	@Test
	void canGetAllCustomersPerCourse() {
		List<Customer> extractedCustomer = customerRepository.findByBookingsCourseName("Python Fundamentals");
		assertEquals(2, extractedCustomer.size());
	}

	@Test
	void canGetAllCoursesPerCustomer() {
		List<Course> extractedCourses = courseRepository.findByBookingsCustomerName("Konrad Talaga");
		assertEquals(3, extractedCourses.size());
	}

	@Test
	void canGetAllBookingsForGivenDate() {
		List<Booking> extractedBookings = bookingRepository.findByDate("06.06.2021");
		assertEquals(2, extractedBookings.size());
	}
}
