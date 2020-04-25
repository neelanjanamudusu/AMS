package com.capgemini.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entity.AMS;
import com.capgemini.service.AMSServiceClass;

@RestController 
@RequestMapping("/AddressManagement")
@CrossOrigin(origins="http://localhost:4900")

public class AMSControllerClass {
	@Autowired
	AMSServiceClass s;
	
	@PostMapping("/AddAddress")
	public String addAddress(@RequestBody AMS address)
	{
		return s.addAddress(address);
	}
	
	@GetMapping("/GetAllUsers")
	public List<AMS> getAllUsers()
	{
		return s.getAllUsers();
		
	}
	
	@GetMapping("/GetUser/userID")
	public Optional<AMS> getUser(@PathVariable("userID") int userID)
	{
		return s.getUser(userID);
	}

	/*
	 * @PutMapping("/UpdateAddress{userID}") public String
	 * updateAddress(@RequestBody AMS userID) { return s.UpdateAddress(userID); }
	 * 
	 * @DeleteMapping("/DeleteAddress{userID}") public String
	 * deleteAddress(@PathVariable("userID") int userID) { return
	 * s.DeleteAddress(userID); }
	 */
	
}