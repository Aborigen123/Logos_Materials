package ua.logos.orm;

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
		
		TeacherDetails teacherDetails = new TeacherDetails();
		teacherDetails.setAge(29);
		teacherDetails.setFirstName("Muhamed");
		teacherDetails.setLastName("Doe");
		teacherDetails.setHobby("PC gaming");
//		
//		Teacher teacher = new Teacher();
//		teacher.setLogin("Teacher_login_2");
//		teacher.setPassword("Teacher_password_2");
//		
//		teacher.setTeacherDetails(teacherDetails);
//		em.persist(teacher); // SAVE Entity to DB
		
//		Teacher teacher = em.find(Teacher.class, new Long(2));
//		System.out.println("Teacher > " + teacher);
//		teacher.setLogin("Teacher_Id_2_Login");
//		em.merge(teacher);
		
		
		
		em.getTransaction().commit();

		em.close();
		factory.close();
	}
}
