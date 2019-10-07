package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Phone;

public class PhoneHelper {

	public PhoneHelper() {

	}

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UserAddressBook");

	public void insertPhone(Phone p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}

	public List<Phone> showAllPhones() {
		EntityManager em = emfactory.createEntityManager();
		List<Phone> allPhones = em.createQuery("SELECT i FROM Phone i").getResultList();
		return allPhones;
	}

	public void deletePhone(Phone toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Phone> typedQuery = em.createQuery(
				"select i from Phone i where i.phoneId = :selectedId", Phone.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getId());
		// we only want one result
		typedQuery.setMaxResults(1);
		// get the result and save it into a new list item
		Phone result = typedQuery.getSingleResult();
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Phone searchForPhoneById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Phone found = em.find(Phone.class, idToEdit);
		em.close();
		return found;
	}

	public void updatePhone(Phone toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public void cleanUp() {
		emfactory.close();
	}

}
