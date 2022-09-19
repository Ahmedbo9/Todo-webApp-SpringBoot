package UdemySpringBoot.WebApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todosCount = 0;

	static {
		todos.add(new Todo(++todosCount, "udmey", "Learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "udmey", "Learn angular", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "udmey", "Learn Mongo", LocalDate.now().plusYears(3), false));
		todos.add(new Todo(++todosCount, "udmey", "Learn React", LocalDate.now().plusYears(4), false));
	}

	public List<Todo> findByUsername(String username) {

		return todos;

	}

	public void addTodo(String name, String description, LocalDate targetDate, boolean done) {

		todos.add(new Todo(++todosCount, name, description, targetDate, done));

	}

	public void deleteById(int id) {
		// todo.getId() == id
		// todo -> todo.getId() == id
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findByid(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;

		return todos.stream().filter(predicate).findFirst().get();

	}

	public void updateTodo(@Valid Todo todo) {

		deleteById(todo.getId());
		todos.add(todo);

	}

}
