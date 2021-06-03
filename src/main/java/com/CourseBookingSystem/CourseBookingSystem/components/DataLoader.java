package com.CourseBookingSystem.CourseBookingSystem.components;

import com.CourseBookingSystem.CourseBookingSystem.models.Booking;
import com.CourseBookingSystem.CourseBookingSystem.models.Course;
import com.CourseBookingSystem.CourseBookingSystem.models.Customer;
import com.CourseBookingSystem.CourseBookingSystem.repositories.BookingRepository;
import com.CourseBookingSystem.CourseBookingSystem.repositories.CourseRepository;
import com.CourseBookingSystem.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){

        Customer customer_1 = new Customer("Ahmet Giritli", "Largs", 29);
        Customer customer_2 =  new Customer("Konrad Talaga", "Aberdeen", 22);

        customerRepository.save(customer_1);
        customerRepository.save(customer_2);

        Course course_1 = new Course("Python Fundamentals", "Glasgow", 6);
        Course course_2 = new Course("Spring", "Edinburgh", 2);
        Course course_3 = new Course("Java Fundamentals", "Aberdeen", 4);

        courseRepository.save(course_1);
        courseRepository.save(course_2);
        courseRepository.save(course_3);

        Booking booking_1 = new Booking("03.06.2021", course_1, customer_1);
        Booking booking_2 = new Booking("04.06.2021", course_3, customer_1);
        Booking booking_3 = new Booking("05.06.2021", course_2, customer_2);
        Booking booking_4 = new Booking("06.06.2021", course_1, customer_2);
        Booking booking_5 = new Booking("06.06.2021", course_3, customer_2);

        bookingRepository.save(booking_1);
        bookingRepository.save(booking_2);
        bookingRepository.save(booking_3);
        bookingRepository.save(booking_4);
        bookingRepository.save(booking_5);
    }


}
