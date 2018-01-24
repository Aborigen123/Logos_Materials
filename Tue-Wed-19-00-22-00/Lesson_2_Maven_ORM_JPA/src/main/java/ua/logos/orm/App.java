package ua.logos.orm;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.logos.orm.entity.Course;
import ua.logos.orm.entity.Student;
import ua.logos.orm.entity.Teacher;
import ua.logos.orm.entity.TeacherDetails;

public class App {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
//		TeacherDetails johnDetails = new TeacherDetails("John_2", "Doe_2", 35, "PS4 gamer");
//		Teacher john = new Teacher("john2_login", "john2_password");
//		em.persist(johnDetails);
//		john.setTeacherDetails(johnDetails);
//		em.persist(john);
		
//		Teacher teacher = em.find(Teacher.class, new Long(1));
//		System.out.println(teacher);
//		teacher.setLogin("John_New_Login");
//		em.merge(teacher);
//		Course course = new Course("MySQL 5", "MySQL - for beginners", new BigDecimal("99.99"));
//		em.persist(course);
//		
//		course.setTeacher(teacher);
//		em.merge(course);
//		
//		course = new Course("Spring Boot", "Spring 5 - for beginners", new BigDecimal("199.99"));
//		em.persist(course);
//		course.setTeacher(teacher);
//		em.merge(course);
//		Student student = new Student("Student_student_3", 23, "Bloger");
//		em.persist(student);
			
		Course course = em.find(Course.class, new Long(3));
		course.getStudents().add(em.find(Student.class, new Long(2)));
		em.merge(course);
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
