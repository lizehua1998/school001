package com.hua.service;

import java.util.List;

import com.hua.pojo.User;

public interface UserService {
	public void addUser(User user);
	public List<User> findUser();
	public User loginuser(User user);
}
