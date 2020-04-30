package com.capgemini.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.dto.AddressDTO;
import com.capgemini.exception.IdNotFoundException;
import com.capgemini.service.AMSService;

@RestController
@RequestMapping("/AddressManagement")
@CrossOrigin("http://localhost:4900")
public class AMSController{
	@Autowired
	private AMSService s;
	
	@PostMapping("/AddAddress")
	public ResponseEntity<String> AddAddress(@RequestBody AddressDTO address) {
		AddressDTO e = s.addAddress(address);
		if (e == null) {
			throw new IdNotFoundException("Enter Valid Id");
		} else {
			return new ResponseEntity<String>("Address added successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/GetAddress/{retailerId}")
	private ResponseEntity<AddressDTO> getAddresss(@PathVariable("retailerId") int retailerId) {
		Optional<AddressDTO> e = s.getAddress(retailerId);
		//return e;
		if (e == null) {
			throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
		} else {
			return new ResponseEntity(e,HttpStatus.OK);
		}
	}

	
	@PutMapping("/UpdateAddress")
	public ResponseEntity<String> UpdateAddress(@RequestBody AddressDTO address) {
		AddressDTO e = s.updateAddress(address);
		if (e == null) {
			throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("Address updated successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	
	@DeleteMapping("/DeleteAddress/{retailerId}")
	private ResponseEntity<String> deleteAddress(@PathVariable("retailerId") int retailerId) {
		Integer e=s.deleteAddress(retailerId);
		if (e == null) {
			throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("Address deleted successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> userNotFound(IdNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
