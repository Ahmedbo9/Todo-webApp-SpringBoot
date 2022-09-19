package UdemySpringBoot.WebApp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")

public class todoControler {

	private TodoService todoservice;

	public todoControler(TodoService todoservice) {
		super();
		this.todoservice = todoservice;
	}

	@RequestMapping("list-todos")
	public String goToTodoList(ModelMap model) {

		List<Todo> todos = todoservice.findByUsername("udmey");

		model.addAttribute("todos", todos);

		return "listTodos";

	}

	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showNewToDoPage(ModelMap model) {
		String username = (String) model.get("name");

		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);

		return "addTodo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addToDoPage(ModelMap model, @Valid Todo todo, BindingResult res) {

		if (res.hasErrors()) {
			return "addTodo";
		}

		String username = (String) model.get("name");

		todoservice.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);

		return "redirect:list-todos";
	}

	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		// Delete todo

		todoservice.deleteById(id);
		return "redirect:list-todos";

	}

	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {

		Todo todo = todoservice.findByid(id);
		model.addAttribute("todo", todo);

		return "addTodo";

	}

	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateToDoPage(ModelMap model, @Valid Todo todo, BindingResult res) {

		if (res.hasErrors()) {
			return "addTodo";
		}

		String username = (String) model.get("name");
		todo.setUsername(username);

		todoservice.updateTodo(todo);

		return "redirect:list-todos";

	}

}
