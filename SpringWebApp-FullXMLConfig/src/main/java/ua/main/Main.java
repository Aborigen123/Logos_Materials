package ua.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.online.course.entity.Course;
import ua.online.course.service.CourseService;
import ua.online.course.service.impl.CourseServiceImpl;

public class Main {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");

		
		CourseService courseService = context.getBean(CourseServiceImpl.class);
		Course c =  courseService.findById(1);
		System.out.println(c);
		
		context.close();
	}

}
