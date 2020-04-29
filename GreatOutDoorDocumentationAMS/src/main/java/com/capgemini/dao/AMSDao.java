package com.capgemini.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.dto.AddressDTO;
@Repository
public interface AMSDao extends JpaRepository<AddressDTO, Integer> {

	Optional<AddressDTO> getRetailor(int retailorID);

	List<AddressDTO> getAllRetailors();

	String save(String addAddress);

}
