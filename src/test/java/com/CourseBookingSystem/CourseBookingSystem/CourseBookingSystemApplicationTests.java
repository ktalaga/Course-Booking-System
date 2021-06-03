package com.CourseBookingSystem.CourseBookingSystem;

import com.CourseBookingSystem.CourseBookingSystem.models.Booking;
import com.CourseBookingSystem.CourseBookingSystem.models.Course;
import com.CourseBookingSystem.CourseBookingSystem.models.Customer;
import com.CourseBookingSystem.CourseBookingSystem.repositories.BookingRepository;
import com.CourseBookingSystem.CourseBookingSystem.repositories.CourseRepository;
import com.CourseBookingSystem.CourseBookingSystem.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



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
		assertEquals(3, extractedCourses.size());
	}

	@Test
	void canGetAllCustomersPerCourse() {
		List<Customer> extractedCustomer = customerRepository.findByBookingsCourseNameIgnoreCase("Python Fundamentals");
		assertEquals(5, extractedCustomer.size());
	}

	@Test
	void canGetAllCoursesPerCustomer() {
		List<Course> extractedCourses = courseRepository.findByBookingsCustomerNameIgnoreCase("Konrad Talaga");
		assertEquals(3, extractedCourses.size());
	}

	@Test
	void canGetAllCoursesPerCustomerLowerCase() {
		List<Course> extractedCourses = courseRepository.findByBookingsCustomerNameIgnoreCase("konrad talaga");
		assertEquals(3, extractedCourses.size());
	}

	@Test
	void canGetAllBookingsForGivenDate() {
		List<Booking> extractedBookings = bookingRepository.findByDate("06.06.2021");
		assertEquals(4, extractedBookings.size());
	}

	@Test
	void canGetAllCustomersInTownForCourse() {
		List<Customer> extractedCustomers = customerRepository.findByBookingsCourseNameAndBookingsCourseTownIgnoreCase("Python Fundamentals", "Glasgow");
		assertEquals(3, extractedCustomers.size());
	}

	@Test
	void canGetCustomersByAgeInTown() {
		List<Customer> extractedCustomers = customerRepository.findByAgeGreaterThanAndBookingsCourseNameAndBookingsCourseTownIgnoreCase(22,"Python Fundamentals", "Glasgow");
		assertEquals(1, extractedCustomers.size());
	}
}
