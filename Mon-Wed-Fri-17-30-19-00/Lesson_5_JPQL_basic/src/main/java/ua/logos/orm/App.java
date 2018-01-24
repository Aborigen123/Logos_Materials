package ua.logos.orm;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
		
//		List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
//		teachers.forEach(t -> System.out.println(t));
		

//		Teacher teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.id = :id", Teacher.class)
//				.setParameter("id", new Long(23))
//				.getSingleResult();
//		System.out.println(teacher);
		
//		List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t WHERE t.login LIKE '%7' AND t.id > :id", Teacher.class)
//				.setParameter("id", new Long(10)).getResultList();
//		teachers.forEach(t -> System.out.println(t));

		
		List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t WHERE t.id BETWEEN :start AND :finish", Teacher.class)
				.setParameter("start", new Long(20))
				.setParameter("finish", new Long(60))
				.getResultList();
		teachers.forEach(t -> System.out.println(t));
		
		List<Teacher> teachers2 = em.createQuery("SELECT t FROM Teacher t WHERE t.id IN (:ids)", Teacher.class)
				.setParameter("ids", Arrays.asList(new Long(10), new Long(34), new Long(45))).getResultList();
		teachers2.forEach(t2 -> System.out.println(t2));
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
