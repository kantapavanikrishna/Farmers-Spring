package com.example.Farmers.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FarmerAccount {

	@GetMapping("/account")
	public String getAccountDetails() {
		return "Here are the account details";
		}
}
