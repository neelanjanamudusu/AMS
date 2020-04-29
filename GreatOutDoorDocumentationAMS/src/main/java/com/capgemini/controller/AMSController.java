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
	AMSService s;
	
	@PostMapping("/AddAddress")
	public String addAddress(@RequestBody AddressDTO RetailorID)
	{
		if ((s.addAddress(RetailorID))!= null)
		{
			return "Added Sucessfully";
		}else 
			return "Unsucessful";
		//return s.addAddress(Address);
	}
	
	@GetMapping("/GetAllRetailors")
	public List<AddressDTO> getAllRetailors()
	{
		return s.getAllRetailors();
		
	}
	
	@GetMapping("/GetRetailor/RetailerID")
	public Optional<AddressDTO> getReatilor(@PathVariable("RetailorID") int RetailorID)
	{
		return s.getRetailor(RetailorID);
	}

}