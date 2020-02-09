package org.Info.Vehicle.service;

import java.util.List;

import javax.transaction.Transactional;

import org.Info.Vehicle.dao.UserDao;
import org.Info.Vehicle.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserService {

	@Autowired
	UserDao userDao;

	@Transactional
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Transactional
	public User getUser(int id) {
		return userDao.getUser(id);
	}

	@Transactional
	public User addUser(User user) {
		userDao.addUser(user);
		return user;
	}

	@Transactional
	public User updateUser(User user) {
		userDao.updateUser(user);
		return user;
	}

	@Transactional
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}
}
