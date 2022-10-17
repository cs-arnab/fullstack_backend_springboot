package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	TodoRepository todoRepository;

	public List<Todo> getAllTodos() {
		return todoRepository.findAll();
	}

	public Optional<Todo> getTodoById(Integer id) {
		try {
			Optional<Todo> todo = todoRepository.findById(id);
			if (todo == null) {
				return null;
			} else {
				System.out.println("date : " + todo.get().getTargetDate());
				return todo;
			}

		} catch (Exception e) {
			System.out.println("Error : " + e);
			return null;
		}
//		return todoRepository.findById(id);
	}

	public Todo updateTodo(Todo todo) {
		try {
			Optional<Todo> todoExisting = todoRepository.findById(todo.getId());
			if (todoExisting == null) {
				return null;
			} else {
				Todo todoExisting1 = new Todo();
				todoExisting1.setId(todo.getId());
				todoExisting1.setDescription(todo.getDescription());
				todoExisting1.setTargetDate(todo.getTargetDate());
				todoExisting1.setUsername(todoExisting.get().getUsername());
				todoExisting1.setDone(todoExisting.get().isDone());
				todoRepository.save(todoExisting1);
				return todoExisting1;
			}
		} catch (Exception e) {
			System.out.println("Error : " + e);
			return null;
		}
	}

	public Todo createTodo(String username, Todo todo) {
		try {
			Optional<Todo> todoP = todoRepository.findById(todo.getId());
			if (todoP != null && !todoP.isEmpty()) {
				return todoP.get();
			} else {
				List<Todo> todos = todoRepository.findAll();
				Integer id = -1;
				for (Todo todoVal : todos) {
					if (todoVal.getId() > id) {
						id = todoVal.getId();
					}
				}
				Todo todoV = new Todo();
				todoV.setId(id + 1);
				todoV.setUsername(username);
				todoV.setDescription(todo.getDescription());
				todoV.setTargetDate(todo.getTargetDate());
				todoV.setDone(todo.isDone());
				todoRepository.save(todoV);
				return todoV;
			}
		} catch (Exception e) {
			System.out.println("11	.	.	.");
			System.out.println("Error : " + e);
			return null;
		}

//		if (todoP != null) {
//			System.out.println("todo already exist . . .");
//			return todoP;
//		}
//		System.out.println("Create server . . . .");
//		todo.setUsername(username);
//		todoRepository.save(todo);
//		return todo;
//		return null;

//		try {
//			Optional<Todo> todo1 = todoRepository.findById(todo.getId());
//			if (!todo1.isEmpty()) {
//				System.out.println("todo already exist . . .");
//				return todo;
//			} else {
//				List<Todo> todos = todoRepository.findAll();
//				Todo todo2 = new Todo();
//				Integer id = -1;
//				for (Todo todoVal : todos) {
//					if (todoVal.getId() > id) {
//						id = todoVal.getId();
//					}
//				}
////				System.out.println("id : " + id);
//				todo2.setId(id + 1);
//				todo2.setDescription(todo.getDescription());
//				todo2.setTargetDate(todo.getTargetDate());
//				todo2.setUsername(todo.getUsername());
//				todo2.setDone(todo.isDone());
//				todoRepository.save(todo2);
//				return todo2;
//			}
//		} catch (Exception e) {
//			System.out.println("Error : " + e);
//			return null;
//		}

	}

	public Todo deleteById(Integer id) {

		try {
			Todo todo = todoRepository.findById(id).get();
			if (todo == null) {
				return null;
			} else {
				todoRepository.deleteById(id);
				return todo;
			}
		} catch (Exception e) {
			System.out.println("Error : " + e);
			return null;
		}
	}
}
