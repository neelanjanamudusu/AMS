package com.capgemini.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class AddressDTO {
@Id
private int AddressID;
private String address;

public int getAddressID() {
	return AddressID;
}
public void setAddressID(int addressID) {
	AddressID = addressID;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
 }