package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.HelloBean;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/")
public class HelloWorldController {
	@GetMapping(path = "/")
	public String helloworld0() {
//		System.out.println("from frontend	.	.	.");
		return "You r at home";
	}

	@GetMapping(path = "/hello")
	public String helloworld() {
//		System.out.println("from frontend	.	.	.");
		return "hello user";
	}

	@GetMapping(path = "/user/{name}")
	public HelloBean helloworld1(@PathVariable String name) {
		return new HelloBean(String.format("hello user bean : %s", name));
	}

	@GetMapping(path = "/bean")
	public HelloBean helloworld2() {
//		System.out.println("from frontend bean	.	.	.");
//		throw new RuntimeException("some error occure");
		return new HelloBean(" data from backend ");
	}
}
