package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="addresslist")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ADDRESSLIST_ID")
	private int addressId;
	@Column(name="TYPE")
	private String type;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="CITY")
	private String city;
	@Column(name="STATE")
	private String state;
	@Column(name="ZIP")
	private String zip;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	public Address(int id, String type, String address, String city, String state, String zip) {
		super();
		this.addressId = id;
		this.type = type;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public Address(String type, String address, String city, String state, String zip) {
		super();
		this.type = type;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int id) {
		this.addressId = id;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	@Override
	public String toString() {
		return "Address [id=" + addressId + ", type=" + type + ", address=" + address + ", city=" 
				+ city + ", state=" + state + ", zip=" + zip + "]";
	}

}
