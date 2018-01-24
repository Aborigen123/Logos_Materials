package ua.logos.orm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.logos.orm.entity.Teacher;
import ua.logos.orm.entity.TeacherDetails;

public class App {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		TeacherDetails details = new TeacherDetails("t_FirstName", "t_LastName", 25, "My Hobby");
		em.persist(details);
		
		Teacher teacher = new Teacher("Teacher_Login", "Teacher_Password");
		teacher.setTeacherDetails(details);
		em.persist(teacher);
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
