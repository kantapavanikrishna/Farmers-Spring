package com.example.Farmers.Controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Farmers.Entity.Farmers;
import com.example.Farmers.Entity.Login;
import com.example.Farmers.Repository.FarmersRepository;
import com.example.Farmers.Repository.LoginRepository;

@RestController
@RequestMapping
//@CrossOrigin(origins="http://localhost:4200")
public class LoginController {

	
	 
	 @Autowired
	 	private LoginRepository loginRepository;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    
//	    @PostMapping("/login")
//	    public ResponseEntity<String> registerUser(@RequestBody Login login) {
//	        Login getLogin = null;
//	        ResponseEntity response = null;
//	        try {
//	            String hashPwd = passwordEncoder.encode(login.getPassword());
//	            login.setPassword(hashPwd);
//	            getLogin = loginRepository.getById()(login);
//	            if (getLogin.getId() > 0) {
//	                response = ResponseEntity
//	                        .status(HttpStatus.CREATED)
//	                        .body("Given user details are successfully registered");
//	            }
//	        } catch (Exception ex) {
//	            response = ResponseEntity
//	                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
//	                    .body("An exception occured due to " + ex.getMessage());
//	        }
//	        return response;
//	    }

//	    @RequestMapping("/user")
//	    public Farmers getUserDetailsAfterLogin(Authentication authentication) {
//	        List<Farmers>farmers = farmersRepository.findByEmail(authentication.getName());
//	        if (farmers.size() > 0) {
//	            return farmers.get(0);
//	        } else {
//	            return null;
//	        }

	   

	        
	        
	        @PostMapping("/welcome")
	        public Login getWelcome(@RequestBody Login login) {
	            String username = login.getUsername();
	            String password = login.getPassword();
	            
	            Login findByUsername = loginRepository.findByUsername(username);

	            
	            
	            boolean status;
	           

	            if(findByUsername != null) {
	                if(password.equals(findByUsername.getPassword())) {
	                    status = true;
	                }
	                else {
	                    status = false;
	                }
	            }
	            else {
	                status = false;
	            }

	            if(status) {
	                //return "Login Successful";
	                return findByUsername;
	            }
	            else {
	                return null;
	            }

	            
	            
	        }
	    }

