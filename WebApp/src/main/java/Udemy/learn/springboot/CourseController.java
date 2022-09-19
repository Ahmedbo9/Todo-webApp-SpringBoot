package Udemy.learn.springboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CourseController {

	// courses
	// Course: id , name , author

	@RequestMapping("/courses")
	public List<Course> retriveAllCourses() {

		return Arrays.asList(

				new Course(1, "AWS", "udemy"), new Course(2, "DevOps", "udemy"), new Course(2, "Azure", "udemy")

		);

	}

}
