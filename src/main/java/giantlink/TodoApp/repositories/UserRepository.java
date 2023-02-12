package giantlink.TodoApp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import giantlink.TodoApp.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

	Optional<User> findByemail(String email);
	
	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	@Query(value = "SELECT u FROM User u where u.username = :username and u.password = :password ")
	Optional<User> login(String username, String password);

}
