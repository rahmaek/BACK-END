package giantlink.TodoApp.services;

import java.util.List;

import giantlink.TodoApp.entities.Todo;

public interface TodoService {

	List<Todo> listTodos();

	Todo createTodo(String title);

	Todo markTodoCompleted(long id);

	Todo markTodoUncompleted(long id);

	void deleteTodo(long id);

}
