package com.capgemini.service;

import java.util.List;

import com.capgemini.entity.AMSEntity;


public interface AMSService {
	AMSEntity updateAddress(AMSEntity address);
	List<AMSEntity> getAddress(int retailerId);
	void deleteAddress(int addressId);
	AMSEntity addAddress(AMSEntity address);
}