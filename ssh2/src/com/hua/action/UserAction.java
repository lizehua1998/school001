package com.hua.action;
import java.util.List;
import com.hua.pojo.User;
import com.hua.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	private User user;//用于封装表单数据
	private String code;//封装用户输入的验证码
	private String islogin;
	private UserService userService;//注入的service对象  做静态页面ajax请求去掉get方法
	public String getIslogin() {
		return islogin;
	}
	public void setIslogin(String islogin) {
		this.islogin = islogin;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private List<User> userList;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public String insert(){
		this.userService.addUser(user);
		this.userList=this.userService.findUser();
		return SUCCESS;
	}
	public String showUser(){
		this.userList=this.userService.findUser();
		return SUCCESS;
	}
	public String loginUser(){
		String cd=(String)ActionContext.getContext().getSession().get(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY); 
		if(cd.equals(code)){
			
			System.out.println(user);
			User u = userService.loginuser(user);
			System.out.println(u);
			//放到会话中
			this.islogin="ok";
			return SUCCESS;
		}else{
			this.islogin="error";
			return SUCCESS;
		}
	}
}
