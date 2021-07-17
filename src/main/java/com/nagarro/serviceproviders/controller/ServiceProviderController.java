package com.nagarro.serviceproviders.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nagp")
public class ServiceProviderController {

	@GetMapping()
	public String getServiceProvider() {
		return "Welcome to NAGP DevOps";
	}

}
