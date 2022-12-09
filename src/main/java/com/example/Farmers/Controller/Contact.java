package com.example.Farmers.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Contact {

	@GetMapping("/contact")
	public String getContactDetails() {
		return "Here are the contact details";
		}
}
