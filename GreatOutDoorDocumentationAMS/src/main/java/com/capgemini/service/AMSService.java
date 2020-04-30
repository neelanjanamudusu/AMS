package com.capgemini.service;

import java.util.Optional;

import com.capgemini.dto.AddressDTO;


public interface AMSService {
	AddressDTO addAddress(AddressDTO address);
	AddressDTO updateAddress(AddressDTO address);
	Optional<AddressDTO> getAddressById(int retailorId);
	Integer  deleteAddress(int retailorId);
}