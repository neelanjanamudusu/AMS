package com.capgemini.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.dto.AddressDTO;
import com.capgemini.service.AMSService;

@RestController 
@RequestMapping("/AddressManagement")
@CrossOrigin(origins="http://localhost:4900")

public class AMSController {
	@Autowired
	private AMSService s;
	
	@PostMapping("/AddAddress")
	public String addAddress(@RequestBody AddressDTO Address)
	{
		return s.addAddress(Address);
	}
	
	@GetMapping("/GetAllRetailors")
	public List<AddressDTO> getAllRetailors()
	{
		return s.getAllRetailors();
		
	}
	
	@GetMapping("/GetRetailor/RetailerID/AddressID")
	public Optional<AddressDTO> getReatilor(@PathVariable("RetailorID, AddressID") int RetailorID, int AddressID)
	{
		return s.getRetailor(RetailorID, AddressID);
	}

}