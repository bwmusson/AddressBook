package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Address;

public class AddressHelper {

	public AddressHelper() {

	}

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UserAddressBook");

	public void insertAddress(Address a) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
	}

	public List<Address> showAllAddresses() {
		EntityManager em = emfactory.createEntityManager();
		List<Address> allAddresses = em.createQuery("SELECT i FROM Address i").getResultList();
		return allAddresses;
	}

	public void deleteAddress(Address toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Address> typedQuery = em.createQuery(
				"select i from Address i where i.addressId = :selectedId", Address.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getId());
		// we only want one result
		typedQuery.setMaxResults(1);
		// get the result and save it into a new list item
		Address result = typedQuery.getSingleResult();
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Address searchForAddressById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Address found = em.find(Address.class, idToEdit);
		em.close();
		return found;
	}

	public void updateAddress(Address toEdit) {
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
