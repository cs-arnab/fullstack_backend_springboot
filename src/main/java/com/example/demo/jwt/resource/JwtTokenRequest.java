package com.example.demo.jwt.resource;

import java.io.Serializable;

public class JwtTokenRequest implements Serializable {

	private static final long serialVersionUID = -5616176897013108345L;

	private String username;
	private String password;
//	{
//	    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTY2NjQ1OTAyNywiaWF0IjoxNjY1ODU0MjI3fQ.pDtUULkKzivzi5r60SgFpT9TyJ3lobkzK3txZEh-pKKngoGJwtadAIc7H-pGTpD9UU_9O8WHzJqUj8DSza9x1w"
//	}

	public JwtTokenRequest() {
		super();
	}

	public JwtTokenRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}