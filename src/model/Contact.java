package model;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "contacts")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CONTACTS_ID")
	private int contactId;
	@Column(name="FIRSTNAME")
	private String firstName;
	@Column(name="LASTNAME")
	private String lastName;
	@Column(name="DOB")
	private LocalDate dob;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
			name="CONTACT_ADDRESSES",
			joinColumns={@JoinColumn(name="CONTACTS_ID",
			referencedColumnName="CONTACTS_ID") },
			inverseJoinColumns={ @JoinColumn(name="ADDRESSLIST_ID",
			referencedColumnName="ADDRESSLIST_ID", unique=true) }
	)
	private List<Address> contactAddresses;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
			name="CONTACT_PHONES",
			joinColumns={@JoinColumn(name="CONTACTS_ID",
			referencedColumnName="CONTACTS_ID") },
			inverseJoinColumns={ @JoinColumn(name="PHONELIST_ID",
			referencedColumnName="PHONELIST_ID", unique=true) }
	)
	private List<Phone> contactPhones;
	
	public Contact() {
		// TODO Auto-generated constructor stub
	}

	public Contact(int id, String firstName, String lastName, LocalDate dob, List<Address> addresses) {
		super();
		this.contactId = id;
		this.dob = dob;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactAddresses = addresses;
	}
	
	public Contact(int id, String firstName, String lastName, LocalDate dob) {
		super();
		this.contactId = id;
		this.dob = dob;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Contact(String firstName, String lastName, LocalDate dob) {
		super();
		this.dob = dob;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int id) {
		this.contactId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public void setContactAddresses(List<Address> ca) {
		this.contactAddresses = ca;
	}
	
	public List<Address> getContactAddresses(){
		return this.contactAddresses;
	}
	
	public void addAddress(Address a) {
		this.contactAddresses.add(a);
	}
	
	public void removeAddress(Address a) {
		Address contAddress = a;
		for(Address ca : this.contactAddresses) {
			if(ca.getAddressId() == a.getAddressId()) {
				contAddress = ca;
			}
		}
		if(this.contactAddresses.contains(contAddress)) {
			this.contactAddresses.remove(contAddress);
		}
		else {
			System.out.println("Address Not Found");
		}
	}
	
	public void setContactPhones(List<Phone> cp) {
		this.contactPhones = cp;
	}
	
	public List<Phone> getContactPhones(){
		return this.contactPhones;
	}
	
	public void addPhone(Phone p) {
		this.contactPhones.add(p);
	}
	
	public void removePhone(Phone p) {
		Phone contPhone = p;
		for(Phone cp : this.contactPhones) {
			if(cp.getPhoneId() == p.getPhoneId()) {
				contPhone = cp;
			}
		}
		if(this.contactPhones.contains(contPhone)) {
			this.contactPhones.remove(contPhone);
		}
		else {
			System.out.println("Phone Not Found");
		}
	}

	@Override
	public String toString() {
		if(!this.contactAddresses.isEmpty() && this.contactPhones.isEmpty()) {
			StringBuilder addresses = new StringBuilder();
			for(Address a : this.contactAddresses) {
				addresses.append(a.toString());
			}
			return "Contact [id=" + contactId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", Addresses: [" + addresses.toString() + "]";
		}
		else if(this.contactAddresses.isEmpty() && !this.contactPhones.isEmpty()) {
			StringBuilder phones = new StringBuilder();
			for(Phone p : this.contactPhones) {
				phones.append(p.toString());
			}
			return "Contact [id=" + contactId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", Phones: [" + phones.toString() + "]";
		}
		else if(!this.contactAddresses.isEmpty() && !this.contactPhones.isEmpty()) {
			StringBuilder addresses = new StringBuilder();
			for(Address a : this.contactAddresses) {
				addresses.append(a.toString());
			}
			StringBuilder phones = new StringBuilder();
			for(Phone p : this.contactPhones) {
				phones.append(p.toString());
			}
			return "Contact [id=" + contactId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", Addresses: [" + addresses.toString() + "], Phones: [" + phones.toString() + "]";
		}
		else {
			return "Contact [id=" + contactId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + "]";
		}
	}
}
