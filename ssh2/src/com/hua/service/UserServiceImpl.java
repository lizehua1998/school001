package com.hua.service;
import java.util.List;
import com.hua.dao.UserDao;
import com.hua.pojo.User;
import com.hua.utils.MD5;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public void addUser(User user) {
		//md5加密存储到数据库
		String md5str = MD5.encrypty(user.getPassword());
		user.setPassword(md5str);
		this.userDao.insert(user);
		
	}
	@Override
	public List<User> findUser() {
		return this.userDao.findall();
	}
	@Override
	public User loginuser(User user) {
		String md5str = MD5.encrypty(user.getPassword());
		user.setPassword(md5str);
		System.out.println("%%"+user);
		return this.userDao.findbyuser(user);
	}

}
