package ua.online.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.online.course.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
