package com.monica.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
@Transactional
public class UserDAOService {
	@PersistenceContext
	private EntityManager entityManager;
	
	private static List<User> Users = new ArrayList<User>();
	private static int userCount = 3;
	static {
		Users.add(new User(1, "Monica", new Date()));
		Users.add(new User(2, "Balu", new Date()));
		Users.add(new User(3, "Sahana", new Date()));
	}

	public List<User> allUsers() {
		return Users;
	}

	public User getUser(int id) {
		for (User user : Users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User addUser(User user) {
		entityManager.persist(user);
		return user;
	}

	public User deleteUser(int id) {
		Iterator<User> iterator = Users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
