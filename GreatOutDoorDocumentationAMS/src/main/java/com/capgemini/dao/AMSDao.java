package com.capgemini.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.entity.AMSEntity;

@Repository
public interface AMSDao extends JpaRepository<AMSEntity, Integer> {

	@Modifying
	@Transactional
    @Query("select d from AMSEntity d where d.retailerId=?1")
    List<AMSEntity> getAddress(int retailerId);
 
}
