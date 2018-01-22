package ua.logos.orm;

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
		
		TeacherDetails johnDetails = new TeacherDetails("John", "Doe", 38, "PC gaming");
		//Teacher john = new Teacher("john_john", "my_password");
		//john.setTeacherDetails(johnDetails);
		//em.persist(john);
		
		Teacher john = em.find(Teacher.class, new Long(3));
		System.out.println(john + "\n" + john.getTeacherDetails());
		john.setLogin("New_Login");
		em.merge(john);
//		Student student = new Student("Student_student", 23, "Programming");
//		em.persist(student);
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
