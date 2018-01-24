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
				
//		for ( int i = 1; i <= 100; i++) {
//			Teacher teacher = new Teacher("Teacher_Login#"+i, "Teacher_Password#"+1);
//			teacher.setTeacherDetails(new TeacherDetails("First_Name#"+i, 
//					"Last_Name#"+i, i+10, "I like PC gaming#"+i));
//			
//			em.persist(teacher);
//		}
		
//		for (int i = 1; i <= 20; i++ ) {
//			Teacher teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.id = :id", Teacher.class)
//					.setParameter("id", new Long(i)).getSingleResult();
//			
//			Course course = new Course("JPQL#" + i, "JPQL - for beginners", new BigDecimal(i + ".99"));
//			course.setTeacher(teacher);
//			em.persist(course);
//		}
		
		for (int i = 1; i < 20; i++) {
			
			Course course = em.createQuery("SELECT c FROM Course c WHERE c.id = :id", Course.class)
					.setParameter("id", new Long(i)).getSingleResult();
			
			Student student = new Student("Full_Name#" + i, i + 10);
			course.getStudents().add(student);
			em.persist(student);
		}
		
//		List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
//		teachers.forEach(t -> System.out.println(t));

//		Teacher teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.id = :id", Teacher.class)
//				.setParameter("id", new Long(45)).getSingleResult();
//		System.out.println(teacher);

//		List<Teacher> teachers = em
//				.createQuery("SELECT t FROM Teacher t WHERE t.login LIKE '%9' AND t.id > :number", Teacher.class)
//				.setParameter("number", new Long(10))
//				.getResultList();
//		teachers.forEach(t -> System.out.println(t));

//		List<Teacher> teachers = em.createQuery(
//				"SELECT t FROM Teacher t WHERE t.id BETWEEN :start AND :finish", Teacher.class)
//				.setParameter("start", new Long(34))
//				.setParameter("finish", new Long(78))
//				.getResultList();
//		teachers.forEach(t -> System.out.println(t));
		
//		List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t WHERE t.id IN (:ids)", Teacher.class)
//				.setParameter("ids", Arrays.asList(new Long(34), new Long(45), new Long(89))).getResultList();
//		teachers.forEach(t -> System.out.println(t));
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
