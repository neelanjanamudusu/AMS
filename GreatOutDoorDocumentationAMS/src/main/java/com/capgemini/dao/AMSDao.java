package com.capgemini.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.dto.AddressDTO;

@Repository
public interface AMSDao extends JpaRepository<AddressDTO, Integer> {
	
	@Transactional
	@Modifying
	@Query("Delete from AddressDTO add where add.retailorId=?1")
	Integer deleteAddress( int retailorId);


}
