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
		
//		Teacher teacher = new Teacher("Teacher_login", "Teacher_password");
//		teacher.setTeacherDetails(new TeacherDetails("Mohamed", "BimBim", 35, "PC gamer"));
//		em.persist(teacher);
		
		Teacher teacher = em.find(Teacher.class, new Long(1));
		System.out.println(teacher);
		teacher.setLogin("Teacher_Login_Updated");
		em.merge(teacher);
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
