package controllers;

import java.util.ArrayList;

import models.User;

public class UserController {
	public boolean save(User user) {
		boolean result = new UserJDBC().save(user);
		return result;
	}
	public User search(int uid) {
		User user = new UserJDBC().search(uid);
		return user;
	}
	public boolean edit(User user) {
		boolean result = new UserJDBC().edit(user);
		return result;
	}
	public boolean delete(int uid) {
		boolean result = new UserJDBC().delete(uid);
		return result;
	}
	public ArrayList all() {
		ArrayList users = new UserJDBC().all();
		return users;
	}
}
