package view;

import java.time.LocalDate;
import java.util.List;

import controller.ContactHelper;
import model.Contact;

public class tester {
	public static void main(String[] args) {
		Contact jasper = new Contact("Jasper", "Smith", LocalDate.now());
		ContactHelper ch = new ContactHelper();
		
		ch.insertContacts(jasper);
		
		List<Contact> allContacts = ch.showAllContacts();
		for(Contact a: allContacts) {
			System.out.println(a.toString());
		}
	}
}
