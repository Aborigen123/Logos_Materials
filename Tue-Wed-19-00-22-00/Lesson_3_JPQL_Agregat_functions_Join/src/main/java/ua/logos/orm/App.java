package ua.logos.orm;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

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
		
//		for (int i = 1; i <= 50; i++) {
//			Teacher teacher = new Teacher("Teacher_login#" + i, "Teacher_Password#"+i);
//			teacher.setTeacherDetails(new TeacherDetails("First_Name#" + i, "Last_Name#"+i, (i+10), "PC gaming#"+i));
//			
//			em.persist(teacher);	
//		}
				
//		List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
//		teachers.forEach(t -> System.out.println(t));
		
//		Teacher teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.id = :id", Teacher.class)
//				.setParameter("id", new Long(35))
//				.getSingleResult();
//		System.out.println(teacher);

//		List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t WHERE t.login LIKE '%8' AND t.id > 10", Teacher.class).getResultList();
//		teachers.forEach(t -> System.out.println(t));
		
//		List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t WHERE t.id BETWEEN :start AND :finish", Teacher.class)
//				.setParameter("start", new Long(20))
//				.setParameter("finish", new Long(30))
//				.getResultList();
//		teachers.forEach(t -> System.out.println(t));
		
//		List<Teacher> teachers2 = em.createQuery("SELECT t FROM Teacher t WHERE t.id IN (:ids)", Teacher.class)
//				.setParameter("ids", Arrays.asList(new Long(23), new Long(45), new Long(12))).getResultList();
// 		teachers2.forEach(t -> System.out.println(t));
 		
		
//		for (int i = 1; i <= 50; i++ ) {
//			Teacher teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.id = :id", Teacher.class)
//					.setParameter("id", new Long(i)).getSingleResult();
//			
//			Course course = new Course("JPQL #" + i, "JPQL for beginners #"+i, new BigDecimal(i + ".99"));
//			course.setTeacher(teacher);
//			
//			em.persist(course);
//		}
		
//		BigDecimal max = em.createQuery("SELECT max(c.price) FROM Course c", BigDecimal.class).getSingleResult();
//		System.out.println("Max: " + max);
//
//		BigDecimal min = em.createQuery("SELECT min(c.price) FROM Course c", BigDecimal.class).getSingleResult();
//		System.out.println("Min: " + min);
//		
//		BigDecimal sum = em.createQuery("SELECT sum(c.price) FROM Course c", BigDecimal.class).getSingleResult();
//		System.out.println("Sum: " + sum);
//		
//		Long count = em.createQuery("SELECT count(c.id) FROM Course c", Long.class).getSingleResult();
//		System.out.println("Count: " + count);
//		
//		Double avg = em.createQuery("SELECT avg(c.price) FROM Course c", Double.class).getSingleResult();
//		System.out.println("AVG: " + avg);
		
//		for (int i = 1; i <= 50; i++ ) {
//			Course course = em.createQuery("SELECT c FROM Course c WHERE c.id = :id", Course.class)
//					.setParameter("id", new Long(i)).getSingleResult();
//			
//			Student student = new Student("Student_FullName#" + i, (i+10), "PS4 gaming #"+i);
//			em.persist(student);
//			
//			course.getStudents().add(student);
//			em.persist(course);
//		}
		
//		Teacher teacher = em.createQuery("SELECT t FROM Teacher t LEFT JOIN t.courses c WHERE c.id = :id", Teacher.class)
//				.setParameter("id", new Long(34)).getSingleResult();
				
		Teacher teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.id = :id", Teacher.class)
				.setParameter("id", new Long(34)).getSingleResult();
		System.out.println(teacher + "\n" + teacher.getTeacherDetails() + "/n" + teacher.getCourses());
		
		em.getTransaction().commit();
		em.close();
		factory.close();	
	}
}

//TeacherDetails johnDetails = new TeacherDetails("John_2", "Doe_2", 35, "PS4 gamer");
//Teacher john = new Teacher("john2_login", "john2_password");
//em.persist(johnDetails);
//john.setTeacherDetails(johnDetails);
//em.persist(john);

//Teacher teacher = em.find(Teacher.class, new Long(1));
//System.out.println(teacher);
//teacher.setLogin("John_New_Login");
//em.merge(teacher);
//Course course = new Course("MySQL 5", "MySQL - for beginners", new BigDecimal("99.99"));
//em.persist(course);
//
//course.setTeacher(teacher);
//em.merge(course);
//
//course = new Course("Spring Boot", "Spring 5 - for beginners", new BigDecimal("199.99"));
//em.persist(course);
//course.setTeacher(teacher);
//em.merge(course);
//Student student = new Student("Student_student_3", 23, "Bloger");
//em.persist(student);
	
//Course course = em.find(Course.class, new Long(3));
//course.getStudents().add(em.find(Student.class, new Long(2)));
//em.merge(course);