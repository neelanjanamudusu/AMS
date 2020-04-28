package com.capgemini.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.dto.AddressDTO;

public interface AMSDao extends JpaRepository<AddressDTO, Integer> {

	Optional<AddressDTO> getRetailor(int retailorID, int addressID);

	List<AddressDTO> getAllRetailors();

	String save(String addAddress);

}
