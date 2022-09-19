package UdemySpringBoot.WebApp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class loggingController {

    public loggingController(AuthenticationService auth) {
	super();
	this.auth = auth;
    }

    private AuthenticationService auth;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    // MODEL : passer des info du controleur a la vue (logique --> affichagfe)

    public String goTologgingPage() {

	return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)

    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {

	if (auth.authenticate(name, password)) {

	    model.put("name", name);
	    model.put("password", password);

	    return "welcome";

	}

	model.put("errorMessage", "Invalid Data please check your password or/and username");
	return "login";

    }

}
