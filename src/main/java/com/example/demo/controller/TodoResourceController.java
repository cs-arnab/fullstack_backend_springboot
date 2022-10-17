package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/users")
public class TodoResourceController {

	@Autowired
	TodoService todoService;

	@GetMapping(path = "")
	public String Home() {
		return "Users home";
	}

//	http://localhost:8081/users/arnab/todos/4
	@PutMapping(path = "/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable Integer id,
			@RequestBody Todo todo) {
//		System.out.println("update . . . .");
		return new ResponseEntity<Todo>(todoService.updateTodo(todo), HttpStatus.OK);
	}

//	http://localhost:8081/users/arnab/todos
	@PostMapping(path = "/{username}/todos")
	public ResponseEntity<Todo> createTodo(@PathVariable String username, @RequestBody Todo todo) {
//		System.out.println("Create controller . . . ." + todo.getUsername() + ", " + todo.getDescription());
		return new ResponseEntity<Todo>(todoService.createTodo(username, todo), HttpStatus.CREATED);
	}

//	http://localhost:8081/users/todos
	@GetMapping(path = "/todos")
	public List<Todo> getAllTodos1() {
		return todoService.getAllTodos();
	}

//	http://localhost:8081/users/arnab/todos
	@GetMapping(path = "/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username) {
		return todoService.getAllTodos();
	}

//	http://localhost:8081/users/arnab/todos/4
	@GetMapping(path = "/{username}/todos/{id}")
	public Optional<Todo> getTodoById(@PathVariable String username, @PathVariable Integer id) {
		return todoService.getTodoById(id);
	}

//	http://localhost:8081/users/arnab/todos/4
	@DeleteMapping(path = "/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable Integer id) {
		Todo todo = todoService.deleteById(id);
		if (todo != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
/*
 * read(GET): /users/arnab/todos delete(DELETE): *
 * /users/{user_name}/todos/{todo_id} update(PUT):
 * /users/{user_name}/todos/{todo_id} Create(POST): /users/{user_name}/todos/
 */