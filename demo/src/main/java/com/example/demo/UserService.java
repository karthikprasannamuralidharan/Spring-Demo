package com.example.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	HashMap<Integer, User> data = new HashMap<>();
	AtomicInteger atoInteger = new AtomicInteger();
	
	public void create(User user) {
		user.setId(atoInteger.incrementAndGet());
		this.data.put(user.getId(), user);
		System.out.println(data);
	}
	public Collection<User> getAll(){
		return this.data.values();
	}
	public void deleteUser(int id) {
		data.remove(id);
	}
	public User getUserById(int id) {
		return data.get(id);
	}
	public void editUser(int id, User user) {
		data.put(id, user);
	}
	
	

}
