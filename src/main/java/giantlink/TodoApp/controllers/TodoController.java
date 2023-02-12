package giantlink.TodoApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import giantlink.TodoApp.entities.Todo;
import giantlink.TodoApp.services.TodoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/todo")
public class TodoController {

	@Autowired
	TodoService todoService;

	@GetMapping(path = { "/listTodo" })
	public List<Todo> findAll() {
		return todoService.listTodos();
	}

	@PostMapping(value = "/create/{title}")
	public Todo create(@PathVariable(value = "title") String title) {
		return todoService.createTodo(title);

	}

	@PostMapping(value = "/completed/{id}")
	public Todo markTodoCompleted(@PathVariable(value = "id") Long id) {
		return todoService.markTodoCompleted(id);

	}

	@PostMapping(value = "/uncompleted/{id}")
	public Todo markTodoUncompleted(@PathVariable(value = "id") Long id) {
		return todoService.markTodoUncompleted(id);

	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		 todoService.deleteTodo(id);
	}

}
