package ua.logos.orm;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ua.logos.orm.entity.Course;
import ua.logos.orm.entity.Student;
import ua.logos.orm.entity.Teacher;
import ua.logos.orm.entity.TeacherDetails;

public class App {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

//		for (int i = 1; i <= 100; i++) {
//			Teacher teacher = new Teacher("teacher_login#" + i, "teacher_password#" + i);
//			teacher.setTeacherDetails(
//					new TeacherDetails("First_Name#" + i, "Last_Name#" + i, i + 10, "PC gaming#" + i));
//			em.persist(teacher);
//		}
//		for (int i = 1; i <= 100; i++) {
//			Teacher teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.id = :id", Teacher.class)
//					.setParameter("id", new Long(i)).getSingleResult();
//
//			Course course = new Course("JPQL course #" + i, "JPQL for beginners #" + i, new BigDecimal(i + ".99"));
//			course.setTeacher(teacher);
//			em.persist(course);
//		}
		
// Teacher teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.id = :id",Teacher.class)
		
		//Об’єкт який дозволяє будувати динамічні запити
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		//Об’єкт запиту параметризований під тип данних що 
		//буде повернено в результаті виконання
		CriteriaQuery<Course> query = cb.createQuery(Course.class);
		//Об’єкт який являється блоком FROM в запиті
		//Ця частина ідентична частині запиту на JPQL 
		//FROM Course i 
		Root<Course> root = query.from(Course.class); 
		//Це звичайний селект, ідентично SELECT c 
 		query.select(root); 
		
 		//Після стрічки вище маємо ось такий запит
 		//SELECT c FROM Course c -- який поверне всі курси з БД
 	    //Тепер потрібно створити умови по яким ми будемо 
 		//фільтрувати товари
 		//Expression - це об’єкт виразу в блоці WHERE
 		//Даний вираз означає наступне с.price
 		Expression<BigDecimal> priceExpression = root.get("price");
 		
 		//Predicate - це вже умова пошуку
 		//Є декілька варіантів як її створити
 		//більшість цих варіантів являється методами CriteriaBuilder
 		//цей метод робить наступну умову greater than or equal
 		//тепер у нас є умова WHERE c.price >= 15.99
 		Predicate pricePredicate = cb.ge(priceExpression, new BigDecimal("15.99"));
 		
 		// Ще одна умова - less than or equal WHERE c.price <= 19.99
 		Predicate pricePredicate2 = cb.le(priceExpression, new BigDecimal("19.99"));
 		
 		//Тепер в нас є 2 умови:
 		//WHERE c.price >= 15.99
 		//WHERE c.price <= 19.99
 		//а потрібно все в одному блоці з оператором AND
 		//CriteriaBuilder знову має метод який 
 		//підходить для даної затачі
 		//він приймає будь-яку кількість об’єктів Predicate
 		//передаємо туди всі що є
 		//отримаємо один десь такий:
 		// WHERE c.price >= 15.99 AND WHERE c.price <= 19.99
 		Predicate allPredicates = cb.and(pricePredicate, pricePredicate2); 		
  		// query.where(allPredicates);
 		
 		Expression<Long> betweenId = root.get("id");
 		Predicate predicateId = cb.between(betweenId, new Long(5), new Long(15));
 		// query.where(predicateId);
 		
 		Expression<String> titleExpression = root.get("title");
 		Predicate titlePredicate = cb.like(titleExpression, "%2");
 		
 		Expression<Long> idExpressionLong = root.get("id");
 		Predicate idExpressionPredicate = cb.ge(idExpressionLong, new Long(10));	
 		Predicate allLikePredicates = cb.and(titlePredicate, idExpressionPredicate);
 		// query.where(allLikePredicates);
 		
 		//Якщо умова вимагає пошуку в інших таблицях
 		//потрібно зробити JOIN
 		//Як і все в Criteria API це також об’єкт
 		//який можна отримати викликавши метод .join(String field)
 		//від об’єкту Root, цим ми змінили блок FROM до такого вигляду
 		//FROM Course c JOIN c.teacher t
 		Join<Course, Teacher> teacherjoin = root.join("teacher");
 		//Це вираз WHERE t.id = 5
 		Expression<Long> teacherIdJoin = teacherjoin.get("id"); 
 		Predicate teacherIdPredicate = cb.equal(teacherIdJoin, new Long(5));

 		query.where(teacherIdPredicate);
 		//JOIN і FETCH в Criteria API це різні речі
 		//і якщо ви хочете зробити fetch
 		//потрібно його викликати окремо не зважаючи на всі інші JOIN
 		root.fetch("teacher");
 		query.distinct(true);
		
 		List<Course> courses = em.createQuery(query).getResultList();
		courses.forEach(c -> System.out.println(c));
 		
		
		// for (int i = 0; i < 100; i++) {
		// Teacher teacher = new Teacher("teacher_login#" + i, "teacher_password#" + i);
		// teacher.setTeacherDetails(new TeacherDetails("First_Name#"+i, "Last_Name#" +
		// i, i + 10, "PC gaming#" + i));
		// em.persist(teacher);
		// }

		// List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t",
		// Teacher.class).getResultList();
		// teachers.forEach(t -> System.out.println(t));

		// Teacher teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.id = :id",
		// Teacher.class)
		// .setParameter("id", new Long(45)).getSingleResult();
		// System.out.println(teacher);

		// List<Teacher> teachers = em
		// .createQuery("SELECT t FROM Teacher t WHERE t.login LIKE '%2' AND t.id > 10",
		// Teacher.class)
		// .getResultList();
		// teachers.forEach(t -> System.out.println(t));

		// List<Teacher> teachers = em
		// .createQuery("SELECT t FROM Teacher t WHERE t.id BETWEEN :start AND :finish",
		// Teacher.class)
		// .setParameter("start", new Long(35))
		// .setParameter("finish", new Long(60))
		// .getResultList();
		// teachers.forEach(t -> System.out.println(t));

		// List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t WHERE id IN
		// (:ids)", Teacher.class)
		// .setParameter("ids", Arrays.asList(new Long(23), new Long(28), new Long(43),
		// new Long(60)))
		// .getResultList();
		// teachers.forEach(t -> System.out.println(t));

		// for(int i = 1; i <= 100; i++ ) {
		// Teacher teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.id = :id",
		// Teacher.class)
		// .setParameter("id", new Long(i)).getSingleResult();
		//
		// Course course = new Course("JPQL course #" + i, "JPQL for beginners #"+i, new
		// BigDecimal(i + ".99"));
		// course.setTeacher(teacher);
		// em.persist(course);
		// }

		// BigDecimal max = em.createQuery("SELECT max(c.price) FROM Course c",
		// BigDecimal.class).getSingleResult();
		// System.out.println("MAX: " + max);
		//
		// BigDecimal min = em.createQuery("SELECT min(c.price) FROM Course c",
		// BigDecimal.class).getSingleResult();
		// System.out.println("MIN: " + min);
		//
		// BigDecimal sum = em
		// .createQuery("SELECT sum(c.price) FROM Course c WHERE c.id BETWEEN :first AND
		// :last", BigDecimal.class)
		// .setParameter("first", new Long(10))
		// .setParameter("last", new Long(40))
		// .getSingleResult();
		// System.out.println("SUM: " + sum);
		//
		// Double avg = em.createQuery("SELECT avg(c.price) FROM Course c",
		// Double.class).getSingleResult();
		// System.out.println("SUM: " + avg);
		//
		// Long count = em.createQuery("SELECT count(c.id) FROM Course c",
		// Long.class).getSingleResult();
		// System.out.println("Count: " + count);

		// JOIN
		// JOIN FETCH

		// Teacher teacher = em.createQuery("SELECT t FROM Teacher t JOIN t.courses c
		// WHERE c.id = :id", Teacher.class)
		// .setParameter("id", new Long(20)).getSingleResult();
		// System.out.println(teacher + "\n" + teacher.getCourses());

		// Teacher teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.id =:id",
		// Teacher.class)
		// .setParameter("id", new Long(15)).getSingleResult();
		// System.out.println(teacher);

		// Course course = em.createQuery("SELECT c FROM Course c WHERE c.id = :id",
		// Course.class)
		// .setParameter("id", new Long(34)).getSingleResult();
		// System.out.println(course);

//		Teacher teacher = em
//				.createQuery("SELECT DISTINCT t FROM Teacher t JOIN FETCH t.courses c WHERE c.id = :id", Teacher.class)
//				.setParameter("id", new Long(45)).getSingleResult();
//		System.out.println(teacher);		
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
