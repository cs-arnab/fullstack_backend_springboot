package com.example.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		for (int i = 1; i <= 10; i++) {
			String encodedString = encoder.encode("aaaa123aaaa");
			System.out.println("encodedString : " + encodedString);
		}

	}
}
/*
 * post : http://localhost:8081/authenticate { "username":"arnab",
 * "password":"aaaa123aaaa" }
 */
//#{
//#    "username":"in28minutes",
//#    "password":"dummy"
//#}
//username set in JwtInMemoryUserDetailsService 
//it will return a token back
//		{
//    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhcm5hYiIsImV4cCI6MTY2NjUwOTI5NywiaWF0IjoxNjY1OTA0NDk3fQ.JEog4eGX7f4etruCSh8cEZtXgXGvx9dbgArcngHSji9G6dr6EedVDqwMIYnQuw8WOXEOreetTcLvOsRAz-12jQ"
//}
