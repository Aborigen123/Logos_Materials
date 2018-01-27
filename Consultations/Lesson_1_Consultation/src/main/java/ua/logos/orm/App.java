package ua.logos.orm;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.logos.orm.entity.Student;
import ua.logos.orm.entity.Subject;
import ua.logos.orm.entity.University;

public class App {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
//		University university = new University("NU Ivan Franko", 1456, "Ivan Franko University");
//		for (int i = 1; i <= 50; i++) { 
//			Student student = new Student("Student_F#" + i, "Student_L#" + i, 65);
//			student.setUniversity(university);
//			
//			university.getStudents().add(student);
//		}
//		em.persist(university);
		
//		for (int i = 60; i < 90; i++ ) {
//			Student student = em.createQuery("SELECT s FROM Student s WHERE s.id = :id", Student.class)
//					.setParameter("id", new Long(i))
//					.getSingleResult();
//			
//			Subject subject = new Subject("Subject #" + i, i, "Description #" + i);
//			em.persist(subject);
//			
//			student.getSubjects().add(subject);
//			em.persist(student);
//		}
		
		List<Student> students = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
		students.forEach(s -> System.out.println(s));

		List<Student> students2 = em.createQuery("SELECT s FROM Student s WHERE "
				+ "s.id BETWEEN :first AND :last", 
				Student.class)
				.setParameter("first", new Long(10))
				.setParameter("last", 30L)
				.getResultList();
		
		students2.forEach(s -> System.out.println(s));		
		
		em.getTransaction().commit();
		
		em.close();
		factory.close();
	}
}
