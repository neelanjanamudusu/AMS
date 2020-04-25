package com.capgemini.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="godams")
public class AMS {
@Id
private int userID;
private String address;
public int getUserID() {
	return userID;
}
public void setUserID(int userID) {
	this.userID = userID;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
 }
