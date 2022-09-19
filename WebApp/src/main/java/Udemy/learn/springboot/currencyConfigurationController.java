package Udemy.learn.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class currencyConfigurationController {

	@Autowired
	private currencyServiceConfiguration config;

	@RequestMapping("/currency-configuration")
	public currencyServiceConfiguration retriveAllCourses() {

		return config;

	}

}
