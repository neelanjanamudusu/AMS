package com.capgemini.controller;

import java.util.List;
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
import com.capgemini.entity.AMSEntity;
import com.capgemini.exception.IdNotFoundException;
import com.capgemini.service.AMSService;

@RestController
@RequestMapping("/AddressManagement")
@CrossOrigin("http://localhost:4200")
public class AMSController{
	
	@Autowired
	private AMSService s;
	@PostMapping("/AddAddress")
		public ResponseEntity<String> addAddress(@RequestBody AMSEntity address) {
		AMSEntity e = s.addAddress(address);
			if (e == null) {
				throw new IdNotFoundException("Enter Valid Id");
			} else {
				return new ResponseEntity<String>("Address created successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}

		@GetMapping("/GetAddress/{retailerId}")
		private ResponseEntity<List<AMSEntity>> getAddress(@PathVariable("retailerId") int retailerId) {
			List<AMSEntity> e = s.getAddress(retailerId);
			if (e == null) {
				throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
			} else {
				return new ResponseEntity<List<AMSEntity>>(e, new HttpHeaders(), HttpStatus.OK);
			}
		}

		
		@PutMapping("/UpdateAddress")
		public ResponseEntity<String> UpdateAddress(@RequestBody AMSEntity address) {
			AMSEntity e = s.updateAddress(address);
			if (e == null) {
				throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
			} else {
				return new ResponseEntity<String>("Address updated successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}

		@DeleteMapping("/DeleteAddress/{addressId}")
		public void deleteAddress(@PathVariable("addressId") int addressId) {
			s.deleteAddress(addressId);
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@ExceptionHandler(IdNotFoundException.class)
		public ResponseEntity<String> userNotFound(IdNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}


	/*@Autowired
	private AMSService s;
	
	@PostMapping("/AddAddress")
	public AMSEntity addAddress(@RequestBody AMSEntity address) {
		return s.addAddress(address);
	}

	@GetMapping("/GetAddress/{retailerId}")
	private List<AMSEntity> getAddresss(@PathVariable("retailerId") int retailerId) {
		 if(s.getAddress(retailerId)!=null) {
			 throw new IdNotFoundException("no retailer found");
		 }
		 else {
			 return s.getAddress(retailerId);
		 }
		
	}

	@PutMapping("/UpdateAddress")
	public AMSEntity updateAddress(@RequestBody AMSEntity address) {
		return s.updateAddress(address);
		
	}
	
	@DeleteMapping("/DeleteAddress/{addressId}")
	private String deleteAddress(@PathVariable("addressId") int addressId) {
     AMSEntity e=s.deleteAddress(addressId);
     if(e==null) {
    	 throw new IdNotFoundException("no addressId found");
     }
     else
	    return "deleted successfully";
		
			
	}
}
*/