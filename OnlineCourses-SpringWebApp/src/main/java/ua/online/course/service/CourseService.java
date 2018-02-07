package ua.online.course.service;

import org.springframework.stereotype.Service;

import ua.online.course.entity.Course;

@Service
public interface CourseService {

	void save(Course course);
	
	Course findByCourseName(String courseName);
	
	Course findById(int id);
	
}
