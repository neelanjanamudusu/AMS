package com.capgemini.service;

import java.util.Optional;

import com.capgemini.dto.AddressDTO;


public interface AMSService {
	AddressDTO addAddress(AddressDTO address);
	AddressDTO updateAddress(AddressDTO address);
	Optional<AddressDTO> getAddress(int retailerId);
	Integer  deleteAddress(int retailerId);
}