package br.com.atech.tddcourse.domain.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	
	public static EntityManagerFactory getEntityManagerFactory() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
		return emf;
	}
	
	public static void persistEntity(EntityManager em, Object entity){
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(entity);
		transaction.commit();
		em.clear();
	}
	
}
