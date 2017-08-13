package com.smm.user.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.smm.user.pojo.User;
import com.smm.user.service.UserService;
import org.apache.struts2.ServletActionContext;


public class UserAction extends ActionSupport implements
        ModelDriven<User> {
	// 模型驱动使用的对象
	private User user = new User();

	public User getModel() {
		return user;
	}

	// 注入UserService
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// 后台登录的执行的方法
	public String login() {
		// 调用service方法完成登录
		User existUser = userService.login(user);
		// 判断
		if (existUser == null) {
			// 用户名或密码错误
			this.addActionError("用户名或密码错误!");
			return "loginFail";
		} else {
			// 登录成功:
			ServletActionContext.getRequest().getSession()
					.setAttribute("existUser", existUser);
			return "loginSuccess";
		}
	}

	public String quit(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
}
