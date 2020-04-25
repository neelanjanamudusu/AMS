package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.AMSDaoClass;
import com.capgemini.entity.AMS;

@Service
@Transactional
public class AMSServiceClass {

	@Autowired
	AMSDaoClass dao;
	public String addAddress(AMS address)
	{
		return "Address Added Successfully";
	}
	
	public List<AMS> getAllUsers()
	{
		List<AMS> user = dao.findAll();
		return user;
	}

	public Optional<AMS> getUser(int userID)
	{
		// TODO Auto-generated method stub
		return dao.findById(userID);
	}

	/*
	 * public String UpdateAddress(AMS userID) { // TODO Auto-generated method stub
	 * boolean e=dao.existById(userID); if(e) return "Updated Address Successfully";
	 * else return "UserID incorrect or not found, Please enter valid UserID"; }
	 * 
	 * public String DeleteAddress(int userID) { // TODO Auto-generated method stub
	 * boolean e=dao.deleteById(userID); if(e) return
	 * "Deleted Address Successfully"; else return
	 * "UserID incorrect or not found, Please enter valid UserID"; }
	 */

	

}
