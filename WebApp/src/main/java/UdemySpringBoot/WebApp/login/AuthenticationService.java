package UdemySpringBoot.WebApp.login;

import org.springframework.stereotype.Service;

@Service

public class AuthenticationService {

    public boolean authenticate(String username, String password) {

	boolean isValidName = username.equalsIgnoreCase("Ahmed");
	boolean isValidPassword = password.equalsIgnoreCase("12345");

	return isValidName && isValidPassword;

    }

}
