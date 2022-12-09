package com.example.Farmers.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Farmers.Entity.Farmers;
import com.example.Farmers.Repository.FarmersRepository;


@RestController
@RequestMapping("/farmers")
//@CrossOrigin(origins="http://localhost:4200")

public class FarmersController {
	
	@Autowired
	private FarmersRepository farmersRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
		
	 @GetMapping
	    public List<Farmers> getAllFarmers()
	    {
	        return farmersRepository.findAll();
	    }

	 
	 //add new employee rest api
	 @PostMapping("/register")
	    public ResponseEntity<String> registerFarmer(@RequestBody Farmers farmers) {
	        Farmers savedFarmers = null;
	        ResponseEntity response = null;
	        try {
	        	String hashPwd=passwordEncoder.encode(farmers.getPwd());
	        	farmers.setPwd(hashPwd);
	            savedFarmers = farmersRepository.save(farmers);
	            if (savedFarmers.getId() > 0) {
	                response = ResponseEntity
	                        .status(HttpStatus.CREATED)
	                        .body("Given user details are successfully registered");
	            }
	        } catch (Exception ex) {
	            response = ResponseEntity
	                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("An exception occured due to " + ex.getMessage());
	        }
	        return response;
	    }
//	 
	 //get employee by id rest api
	 @GetMapping("/{id}")
	 public ResponseEntity getbyid(@PathVariable("id") int id) {
	        return new ResponseEntity(farmersRepository.findById(id), HttpStatus.OK);
	    }
//	 
	 //update employee
	 @PutMapping("/{id}")
	    public ResponseEntity updateEmployeebyid(@RequestBody Farmers farmers,@PathVariable("id") int id) {
	        try {
	        	Farmers existfarmers= farmersRepository.findById(id).get();
	        	farmersRepository.save(farmers);
	            return new ResponseEntity<>(farmersRepository.findById(id),HttpStatus.OK);
	        }catch (NoSuchElementException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }}
	        
	     
	        @DeleteMapping("/{id}")
	        public void deleteEmployee(@PathVariable("id") int id) {
	            this.farmersRepository.deleteById(id);
      }

}
