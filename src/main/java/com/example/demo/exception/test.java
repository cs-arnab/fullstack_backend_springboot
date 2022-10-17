package com.example.demo.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class test {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void deleteTodo(int id) {
		jdbcTemplate.update("delete from todo where id=?", id);
	}

}
