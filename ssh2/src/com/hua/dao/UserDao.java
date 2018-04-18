package com.hua.dao;
import java.io.Serializable;
import java.util.List;
import com.hua.pojo.User;
public interface UserDao {
	public void insert(User user);
	public void delete(Serializable id);
	public void update(User user);
	public User findbyid(Serializable id);
	public List<User> findall();
	public User findbyuser(User user);
}
