package com.bbt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leads")
public class Lead {

@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
private String fname;
private String lname;
private String email;
private long Mobile;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getMobile() {
	return Mobile;
}
public void setMobile(long mobile) {
	this.Mobile = mobile;
}


}
