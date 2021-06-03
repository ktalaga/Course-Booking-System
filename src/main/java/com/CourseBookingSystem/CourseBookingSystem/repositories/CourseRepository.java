package com.CourseBookingSystem.CourseBookingSystem.repositories;

import com.CourseBookingSystem.CourseBookingSystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
