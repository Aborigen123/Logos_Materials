package ua.logos.orm2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.logos.orm2.entity.Actor;
import ua.logos.orm2.entity.Category;
import ua.logos.orm2.entity.Gender;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		Actor actor = new Actor("JENIFFER", "ANISTON", Gender.FEMALE, "FEBRUARY 11, 1969");
		em.persist(actor);
		
		Category category = new Category("ADVENTURE");
		em.persist(category);
		category = new Category("ACTION");
		em.persist(category);
		category = new Category("COMEDY");
		em.persist(category);
		category = new Category("HORROR");
		em.persist(category);
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
