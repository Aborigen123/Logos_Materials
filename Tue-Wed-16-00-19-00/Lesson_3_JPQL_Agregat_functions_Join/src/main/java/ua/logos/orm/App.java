package ua.logos.orm;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.logos.orm.entity.Course;
import ua.logos.orm.entity.Teacher;
import ua.logos.orm.entity.TeacherDetails;

public class App {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();

//		for (int i = 1; i <= 100; i++) {
//			Teacher teacher = new Teacher("Teacher_Login#" + i, "Teacher_Password#" + i);
//			teacher.setTeacherDetails(new TeacherDetails("First_name#"+i, "Last_name#"+i, 23, "PC gamer#"+i));
//			em.persist(teacher);
//		}
		
//		List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
//		teachers.forEach(t -> System.out.println(t));
		
//		for(int i = 1; i <= 100; i++) {
//			Teacher teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.id = :id", Teacher.class)
//				.setParameter("id", new Long(i))
//				.getSingleResult();
//			
//			Course course = new Course("MySQL Course#" + i, "MySQL for Beginners#"+i, new BigDecimal(i + ".99"));
//			course.setTeacher(teacher);
//			em.persist(course);
//		}
		
//		List<Teacher> teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.id > :id", Teacher.class)
//				.setParameter("id", new Long(10)).getResultList();
//		teacher.forEach(t -> System.out.println(t));
			
//		List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t WHERE t.login LIKE '%9_'", Teacher.class).getResultList();
//		teachers.forEach(t -> System.out.println(t));
		
//		List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t WHERE t.id BETWEEN :first AND :finish", Teacher.class)
//				.setParameter("first", new Long(20))
//				.setParameter("finish", new Long(30))
//				.getResultList();
//		teachers.forEach(t -> System.out.println(t));
		

//		List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t WHERE t.id IN (:ids)", Teacher.class)
//				.setParameter("ids", Arrays.asList(new Long(23), new Long(56), new Long(67))).getResultList();
//		teachers.forEach(t -> System.out.println(t));
		
		BigDecimal max = em.createQuery("SELECT max(c.price) FROM Course c", BigDecimal.class).getSingleResult();
		System.out.println(max);
		
		BigDecimal min = em.createQuery("SELECT min(c.price) FROM Course c", BigDecimal.class).getSingleResult();
		System.out.println(min);
		
		BigDecimal sum = em.createQuery("SELECT sum(c.price) FROM Course c", BigDecimal.class).getSingleResult();
		System.out.println(sum);
		
		Long count = em.createQuery("SELECT count(t.id) FROM Teacher t", Long.class).getSingleResult();
		System.out.println(count);
		
//		Teacher teacher = new Teacher("Teacher_Login", "Teacher_Password");
//		teacher.setTeacherDetails(new TeacherDetails("First_name", "Last_name", 23, "PC gamer"));
//		em.persist(teacher);
				
//		TeacherDetails details = new TeacherDetails("t_FirstName", "t_LastName", 25, "My Hobby");
//		em.persist(details);	
//		Teacher teacher = new Teacher("Teacher_Login", "Teacher_Password");
//		teacher.setTeacherDetails(details);
//		em.persist(teacher);
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}

















