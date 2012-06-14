package org.apache.shiro.samples.sprhib.action;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.samples.sprhib.model.User;
import org.apache.shiro.samples.sprhib.service.UserService;
import org.apache.shiro.samples.sprhib.vo.LoginVo;
import org.apache.shiro.samples.sprhib.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class ShiroAction extends ActionSupport {
	private UserService userService;

	private List<User> users;

	private LoginVo command;
	
	private UserVo user;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String home() {
		users = userService.getAllUsers();
		return SUCCESS;
	}

	public String login() {
		if(command == null)
			return INPUT;
		
		UsernamePasswordToken token = new UsernamePasswordToken(getCommand()
				.getUsername(), getCommand().getPassword(), getCommand()
				.isRememberMe());
		try {
			SecurityUtils.getSubject().login(token);
		} catch (AuthenticationException e) {
			addActionError("Invalid username or password.  Please try again.");
			return INPUT;
		}

		return SUCCESS;

	}
	
	public String signup(){
		 // Create the user
        userService.createUser(user.getUsername(), user.getEmail(), user.getPassword() );

        // Login the newly created user
        //SecurityUtils.getSubject().login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));

        return SUCCESS;
	}

	public String logout() {
		SecurityUtils.getSubject().logout();
		return SUCCESS;
	}

	public LoginVo getCommand() {
		return command;
	}

	public void setCommand(LoginVo command) {
		this.command = command;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public UserVo getUser() {
		return user;
	}

	public void setUser(UserVo user) {
		this.user = user;
	}

}
