package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Contact;

public class ContactHelper {
	
	public ContactHelper() {
		
	}

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UserAddressBook");

	public void insertContacts(Contact c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}

	public List<Contact> showAllContacts() {
		EntityManager em = emfactory.createEntityManager();
		List<Contact> allContacts = em.createQuery("SELECT i FROM Contact i").getResultList();
		return allContacts;
	}

	public void deleteContacts(Contact toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Contact> typedQuery = em.createQuery(
				"select co from Contact co where co.firstName = :selectedFirstName and co.lastName = :selectedLastName and co.dob = :selectedDob",
				Contact.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedFirstName", toDelete.getFirstName());
		typedQuery.setParameter("selectedLastName", toDelete.getLastName());
		typedQuery.setParameter("selectedDob", toDelete.getDob());
		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		Contact result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public Contact searchForContactsById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Contact found = em.find(Contact.class, idToEdit);
		em.close();
		return found;
	}

	public void updateContacts(Contact toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	/*
	public List<Contact> searchForContactsByFirstName(String first) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Contact> typedQuery = em.createQuery("select co from Contact co where co.firstName = :selectedFirstName",
				Contact.class);
		typedQuery.setParameter("selectedFirstName", first);

		List<Contact> foundContacts = typedQuery.getResultList();
		em.close();
		return foundContacts;
	}

	public List<Contact> searchForContactsByLastName(String last) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Contact> typedQuery = em.createQuery("select co from Contact co where co.lastName = :selectedLastName",
				Contact.class);
		typedQuery.setParameter("selectedLastName", last);

		List<Contact> foundContacts = typedQuery.getResultList();
		em.close();
		return foundContacts;
	}
	
	//Date format need to be fixed
	/*public List<Contact> searchForContactsByDob(String birthday) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Contact> typedQuery = em.createQuery("select co from Contact co where co.dob = :selectedDob",
				Contact.class);
		typedQuery.setParameter("selectedDob", birthday);

		List<Contact> foundContacts = typedQuery.getResultList();
		em.close();
		return foundContacts;
	}*/

	public void cleanUp() {
		emfactory.close();
	}
}
