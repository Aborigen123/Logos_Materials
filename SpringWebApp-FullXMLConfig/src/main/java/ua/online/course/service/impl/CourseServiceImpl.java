package ua.online.course.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.online.course.entity.Course;
import ua.online.course.repository.CourseRepository;
import ua.online.course.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	private CourseRepository courseRepository;

	public CourseServiceImpl(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}

	@Override
	public void save(Course course) {
		// TODO Auto-generated method stub

	}

	@Override
	public Course findByCourseName(String courseName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course findById(int id) {
		return courseRepository.findOne(id);
	}

}
