package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AuthenticationBean;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

//	http://localhost:8081/auth/basicauth
	@GetMapping(path = "/basicauth")
	public AuthenticationBean basicAuth() {
		return new AuthenticationBean("You are authenticated");
	}

}
