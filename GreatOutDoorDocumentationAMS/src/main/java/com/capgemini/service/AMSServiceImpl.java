package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.dao.AMSDao;
import com.capgemini.dto.AddressDTO;


public class AMSServiceImpl implements AMSService  {
	@Autowired 
	private AMSDao dao;

	@Override
	public String addAddress(AddressDTO Address) {
		return dao.save(addAddress(Address));
	}

	@Override
	public List<AddressDTO> getAllRetailors() {
		// TODO Auto-generated method stub
		return dao.getAllRetailors();
	}

	@Override
	public Optional<AddressDTO> getRetailor(int retailorID) {
		// TODO Auto-generated method stub
		return dao.getRetailor(retailorID);
	}
}
