package ua.logos.orm;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

		
		List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t WHERE id IN (:ids)", Teacher.class)
				.setParameter("ids", Arrays.asList(new Long(23), new Long(28), new Long(43), new Long(60)))
				.getResultList();
		teachers.forEach(t -> System.out.println(t));
		
		
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
