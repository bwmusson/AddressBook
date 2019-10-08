package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="phonelist")
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PHONELIST_ID")
	private int phoneId;
	@Column(name="TYPE")
	private String type;
	@Column(name="NUMBER")
	private String number;
	
	public Phone() {
		// TODO Auto-generated constructor stub
	}
	
	public Phone(int phoneId, String type, String number) {
		super();
		this.phoneId = phoneId;
		this.type = type;
		this.number = number;
	}
	
	public Phone(String type, String number) {
		super();
		this.type = type;
		this.number = number;
	}
	
	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int id) {
		this.phoneId = id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Phone [id=" + phoneId + ", type=" + type + ", number=" + number + "]";
	}
}
