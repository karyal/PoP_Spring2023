package controllers;

import models.User;

public class UserController {
	public boolean save(User user) {
		boolean result = new UserJDBC().save(user);
		return result;
	}
}
