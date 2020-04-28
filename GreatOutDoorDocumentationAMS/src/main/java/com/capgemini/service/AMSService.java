package com.capgemini.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.capgemini.dto.AddressDTO;

@Service
@Transactional
public interface AMSService {

	String addAddress(AddressDTO address);
	 List<AddressDTO> getAllRetailors();
     Optional<AddressDTO> getRetailor(int retailorID, int addressID);
}