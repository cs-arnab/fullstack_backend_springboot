//package com.example.demo.exception;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//import org.springframework.stereotype.Repository;
//
//import com.example.demo.model.Todo;
//
//@Repository
//@Transactional
//public class TodoRepository {
////	@Autowired
//	@PersistenceContext
//	private EntityManager entityManager;
//
////	create
//	public void insert(Todo todo) {
//		entityManager.merge(todo);
//	}
//
////	read
//	public Todo findById(Integer id) {
//		return entityManager.find(Todo.class, id);
//	}
//
////	update
//	public void update(Todo todo) {
//		entityManager.merge(todo);
//	}
//
////	delete
//	public void deleteTodoById(Integer id) {
//		Todo todo = entityManager.find(Todo.class, id);
//		entityManager.remove(todo);
//	}
//}
