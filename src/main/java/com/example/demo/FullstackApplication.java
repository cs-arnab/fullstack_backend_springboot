package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;

@SpringBootApplication
public class FullstackApplication implements CommandLineRunner {
	@Autowired
	TodoService todoService;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(FullstackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("	.	.	.	App is running	.	.	.");
		System.out.println("	.	.	.	App is running	.	.	.");
//		System.out.println("delete : " + todoService.deleteById(10));
//		System.out.println(jdbcTemplate.update("delete from todo_data where id=?", 23));
//		System.out.println(jdbcTemplate.update("update todo_data set DESCRIPTION='acccc' where id=?", 1));
//		String Insert_Query = "insert into SYSTEM.TODO_DATA (ID,USERNAME,DESCRIPTION,TARGET_DATE,IS_DONE) "
//				+ "values (50,'aaa5','abcd5',to_date('12-10-22','DD-MM-RR'),'true')";
//		System.out.println(jdbcTemplate.update(Insert_Query));
//		insertData(new Todo(52, "arijit", "my todo", new Date(2000, 11, 21), true));
//		System.out.println(findById(1).getUsername());

	}

	public Todo findById(Integer id) {
//		String Insert_Query = "insert into TODO_DATA (ID,USERNAME,DESCRIPTION,TARGET_DATE,IS_DONE) "
//				+ "values (?,?,?,?,?)";

//		System.out.println(jdbcTemplate.update(Insert_Query, todo.getId(), todo.getUsername(), todo.getDescription(),
//				todo.getTargetDate(), todo.isDone()));
		String query = "select * from TODO_DATA where id=?";
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Todo.class), id);
	}

}
