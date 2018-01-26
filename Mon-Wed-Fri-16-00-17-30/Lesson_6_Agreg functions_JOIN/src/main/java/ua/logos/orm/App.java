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
		
//		for (int i = 0; i < 100; i++) {
//			Teacher teacher = new Teacher("teacher_login#" + i, "teacher_password#" + i);
//			teacher.setTeacherDetails(new TeacherDetails("First_Name#"+i, "Last_Name#" + i, i + 10, "PC gaming#" + i));
//			em.persist(teacher);
//		}

//		List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
//		teachers.forEach(t ->  System.out.println(t));
		
//		Teacher teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.id = :id", Teacher.class)
//				.setParameter("id", new Long(45)).getSingleResult();
//		System.out.println(teacher);
		
//		List<Teacher> teachers = em
//				.createQuery("SELECT t FROM Teacher t WHERE t.login LIKE '%2' AND t.id > 10", Teacher.class)
//				.getResultList();
//		teachers.forEach(t -> System.out.println(t));

		
//		List<Teacher> teachers = em
//				.createQuery("SELECT t FROM Teacher t WHERE t.id BETWEEN :start AND :finish", Teacher.class)
//				.setParameter("start", new Long(35))
//				.setParameter("finish", new Long(60))
//				.getResultList();
//		teachers.forEach(t -> System.out.println(t));
		
//		List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t WHERE id IN (:ids)", Teacher.class)
//				.setParameter("ids", Arrays.asList(new Long(23), new Long(28), new Long(43), new Long(60)))
//				.getResultList();
//		teachers.forEach(t -> System.out.println(t));
		
//		for(int i = 1; i <= 100; i++ ) {
//			Teacher teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.id = :id", Teacher.class)
//					.setParameter("id", new Long(i)).getSingleResult();
//			
//			Course course = new Course("JPQL course #" + i, "JPQL for beginners #"+i, new BigDecimal(i + ".99"));
//			course.setTeacher(teacher);
//			em.persist(course);
//		}
		
//		BigDecimal max = em.createQuery("SELECT max(c.price) FROM Course c", BigDecimal.class).getSingleResult();
//		System.out.println("MAX: " + max);
//		
//		BigDecimal min = em.createQuery("SELECT min(c.price) FROM Course c", BigDecimal.class).getSingleResult();
//		System.out.println("MIN: " + min);
//															
//		BigDecimal sum = em
//				.createQuery("SELECT sum(c.price) FROM Course c WHERE c.id BETWEEN :first AND :last", BigDecimal.class)
//				.setParameter("first", new Long(10))
//				.setParameter("last", new Long(40))
//				.getSingleResult();
//		System.out.println("SUM: " + sum);
//		
//		Double avg = em.createQuery("SELECT avg(c.price) FROM Course c", Double.class).getSingleResult();
//		System.out.println("SUM: " + avg);
//		
//		Long count = em.createQuery("SELECT count(c.id) FROM Course c", Long.class).getSingleResult();
//		System.out.println("Count: " + count);
		
		// JOIN  
		// JOIN FETCH
		
//		Teacher teacher = em.createQuery("SELECT t FROM Teacher t JOIN t.courses c WHERE c.id = :id", Teacher.class)
//				.setParameter("id", new Long(20)).getSingleResult();
//		System.out.println(teacher + "\n" + teacher.getCourses());
		
//		Teacher teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.id =:id", Teacher.class)
//				.setParameter("id", new Long(15)).getSingleResult();
//		System.out.println(teacher);

//		Course course = em.createQuery("SELECT c FROM Course c WHERE c.id = :id", Course.class)
//				.setParameter("id", new Long(34)).getSingleResult();
//		System.out.println(course);
		
		Teacher teacher = em
				.createQuery("SELECT DISTINCT t FROM Teacher t JOIN FETCH t.courses c WHERE c.id = :id", Teacher.class)
				.setParameter("id", new Long(45)).getSingleResult();
		System.out.println(teacher);
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
