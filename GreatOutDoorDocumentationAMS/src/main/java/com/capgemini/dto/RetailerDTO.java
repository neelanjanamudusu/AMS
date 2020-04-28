package com.capgemini.dto;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Retailer")
public class RetailerDTO {
	@Id
	@GeneratedValue
	private int RetailerID;
	@OneToMany(cascade=CascadeType.ALL)
	private List<AddressDTO> Address=new ArrayList<AddressDTO>();
	@SuppressWarnings("unused")
	private Object RetailorID;
	
	public List<AddressDTO> getAddress() {
		return Address;
	}
	
	public RetailerDTO(int RetailorID, String Password, List<AddressDTO> Address) {
		super();
		this. RetailorID =  RetailorID;
		this.Address = Address;
	}
	
	public int getRetailerID() {
		return RetailerID;
	}
	public void setRetailerID(int retailerID) {
		RetailerID = retailerID;
	}
}
