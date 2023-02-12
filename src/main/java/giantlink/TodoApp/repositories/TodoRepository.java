package giantlink.TodoApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import giantlink.TodoApp.entities.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{
	
	List<Todo> findByIsCompletedTrue();
	List<Todo> findByIsCompletedFalse();

}
