package com.capgemini.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.AMSDao;
import com.capgemini.dto.AddressDTO;

@Service
public class AMSServiceImpl implements AMSService  {
	@Autowired 
	private AMSDao dao;

	@Override
	public AddressDTO addAddress(AddressDTO address) {
		return dao.save(address);
	}
	
	@Override
	public AddressDTO updateAddress(AddressDTO address) {
		return dao.save(address);
	}

	@Override
	public Integer deleteAddress(int retailerId) {
		return dao.deleteAddress(retailerId);
	}

	@Override
	public Optional<AddressDTO> getAddress(int retailerId) {
		return dao.findById(retailerId);
	}
	
}

