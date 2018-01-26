package ua.logos.orm;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import ua.logos.orm.entity.Course;
import ua.logos.orm.entity.Teacher;
import ua.logos.orm.entity.TeacherDetails;

public class App {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
//		for (int i = 0; i < 100; i++ ) {
//			Teacher teacher = new Teacher("Teacher_Login#" + (i+1), "Teacher_Password#" + (i+1));
//			teacher.setTeacherDetails(new TeacherDetails("First_Name#" + (i+1), 
//					"Last_Name#" + (i + 1), 10 + i, "I am gamer#" + i));
//			
//			em.persist(teacher);	
//		}
		
//		for (int i = 1; i <= 100; i++) {
//			Teacher teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.id = :id", Teacher.class)
//					.setParameter("id", new Long(i))
//					.getSingleResult();
//
//			Course course = new Course("JPQL course #" + i, "JPQL for beginners #" + i, new BigDecimal(i + ".99"));
//			course.setTeacher(teacher);
//			
//			em.persist(course);
//		}
		
//		BigDecimal max = em.createQuery("SELECT max(c.price) FROM Course c", BigDecimal.class).getSingleResult();
//		System.out.println("MAX: " + max);
//		
//		BigDecimal min = em.createQuery("SELECT min(c.price) FROM Course c", BigDecimal.class).getSingleResult();
//		System.out.println("MIN: " + min);
//		
//		BigDecimal sum = em.createQuery("SELECT sum(c.price) FROM Course c WHERE c.id BETWEEN :first AND :last", BigDecimal.class)
//				.setParameter("first", 10L)
//				.setParameter("last", 40L)
//				.getSingleResult();
//		System.out.println("SUM: " + sum);
//		
//		Double avg = em.createQuery("SELECT avg(c.price) FROM Course c", Double.class).getSingleResult();
//		System.out.println("AVG: " + avg);
//		
//		Long count = em.createQuery("SELECT count(c) FROM Course c", Long.class).getSingleResult();
//		System.out.println("Count: " + count);
		
		
		// JOIN - JOIN FETCH
//		Teacher teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.id = :id", Teacher.class)
//				.setParameter("id", 10L)
//				.getSingleResult();
//		System.out.println(teacher);
		
//		Teacher teacher = em.createQuery("SELECT t FROM Teacher t JOIN t.courses c WHERE c.id = :id", Teacher.class)
//				.setParameter("id", 23L)
//				.getSingleResult();
//		System.out.println(teacher);
		
//		Teacher teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.id = :id", Teacher.class)
//		.setParameter("id", 10L)
//		.getSingleResult();
//		System.out.println(teacher + "\n");
			
//		Course course = em.createQuery("SELECT c FROM Course c WHERE c.id = :id", Course.class)
//				.setParameter("id", 10L)
//				.getSingleResult();
//		System.out.println(course);
		
		Teacher teacher = em.createQuery("SELECT t FROM Teacher t JOIN FETCH t.courses c WHERE c.id = :id", Teacher.class)
		.setParameter("id", 23L)
		.getSingleResult();
		System.out.println(teacher);
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}


//List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
//teachers.forEach(t -> System.out.println(t));	

//Teacher teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.id = :id", Teacher.class)
//		.setParameter("id", new Long(23))
//		.getSingleResult();
//System.out.println(teacher);

//List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t WHERE t.login LIKE '%7' AND t.id > :id", Teacher.class)
//		.setParameter("id", new Long(10)).getResultList();
//teachers.forEach(t -> System.out.println(t));

//List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t WHERE t.id BETWEEN :start AND :finish", Teacher.class)
//		.setParameter("start", new Long(20))
//		.setParameter("finish", new Long(60))
//		.getResultList();
//teachers.forEach(t -> System.out.println(t));

//List<Teacher> teachers2 = em.createQuery("SELECT t FROM Teacher t WHERE t.id IN (:ids)", Teacher.class)
//		.setParameter("ids", Arrays.asList(new Long(10), new Long(34), new Long(45))).getResultList();
//teachers2.forEach(t2 -> System.out.println(t2));
