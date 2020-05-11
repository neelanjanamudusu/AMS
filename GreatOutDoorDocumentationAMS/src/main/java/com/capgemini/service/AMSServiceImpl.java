package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.AMSDao;
import com.capgemini.entity.AMSEntity;

@Service
public class AMSServiceImpl implements AMSService  {
	@Autowired 
	private AMSDao dao;

	@Override
	public List<AMSEntity> getAddress(int retailerId) {
		return dao.getAddress(retailerId);
	}

	@Override
	public AMSEntity addAddress(AMSEntity address) {
	    return dao.save(address);
	}

	@Override
	public AMSEntity updateAddress(AMSEntity address) {
		System.out.println(address.getRetailerId());
		System.out.println(dao.existsById(address.getRetailerId()));
		if(dao.existsById(address.getAddressId()))
			return dao.save(address);
		else 
			return null;
	}
	
	@Override
	public void deleteAddress(int addressId) {
		dao.deleteById(addressId);
		
	}
}

