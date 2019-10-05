package controller;

import java.util.List;

import model.Address;
import model.Contact;

public class BenTester {

	public static void main(String[] args) {

		ContactHelper ch = new ContactHelper();
		AddressHelper ah = new AddressHelper();
		
		
		Address test = new Address("Work", "256 Paper Street", "Anytown", "NY", "12345");
		//ah.insertAddress(sample);
		
		Contact linda = ch.searchForContactsById(3);
		//List<Address> lad = linda.getContactAddresses();
		//Address sample = lad.get(0);
		linda.addAddress(test);
		ch.updateContacts(linda);
		//linda.removeAddress(sample);
		//ch.updateContacts(linda);
		
		//

		List<Contact> allContacts = ch.showAllContacts();

		for(Contact c : allContacts) {
			System.out.println(c.toString());
		}
	}

}
