package giantlink.TodoApp.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import giantlink.TodoApp.entities.Todo;
import giantlink.TodoApp.repositories.TodoRepository;
import giantlink.TodoApp.services.TodoService;

@Service
public class TodoServiceImplementation implements TodoService {

	@Autowired
	TodoRepository todoRepository;

	@Override
	public List<Todo> listTodos() {
		return todoRepository.findAll();
	}

	@Override
	public Todo createTodo(String title) {
		return todoRepository.save(new Todo(title, false));
	}

	@Override
	public Todo markTodoCompleted(long id) {
		Optional<Todo> todoOpt = todoRepository.findById(id);
		if (todoOpt.isPresent()) {
			Todo todo = todoOpt.get();
			todo.setCompleted(true);
			return todoRepository.save(todo);
		}
		return null;
	}

	@Override
	public Todo markTodoUncompleted(long id) {
		Optional<Todo> todoOpt = todoRepository.findById(id);
		if (todoOpt.isPresent()) {
			Todo todo = todoOpt.get();
			todo.setCompleted(false);
			 return todoRepository.save(todo);
		}
		return null;

	}

	@Override
	public void deleteTodo(long id) {
		Optional<Todo> todoOpt = todoRepository.findById(id);
		if (todoOpt.isPresent()) {
			Todo todo = todoOpt.get();
			todo.setCompleted(false);
			todoRepository.delete(todo);
		}

		
	}

}
