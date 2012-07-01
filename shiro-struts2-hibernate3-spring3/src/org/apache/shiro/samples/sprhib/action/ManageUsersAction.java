package org.apache.shiro.samples.sprhib.action;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.samples.sprhib.model.User;
import org.apache.shiro.samples.sprhib.service.UserService;
import org.apache.shiro.samples.sprhib.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.opensymphony.xwork2.ActionSupport;

public class ManageUsersAction extends ActionSupport {
	private UserService userService;

	private List<User> users;

	private UserVo command;

	private Long userId;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequiresPermissions("user:manage")
	public String manageUsers() {
		users = userService.getAllUsers();
		
		return SUCCESS;
	}

	@RequiresPermissions("user:edit")
	public String editUser() {

		User user = userService.getUser(userId);
		command = new UserVo();
		command.setUserId(userId);
		command.setUsername(user.getUsername());
		command.setEmail(user.getEmail());
		
		return "editUser";
	}

	@RequiresPermissions("user:update")
	public String updateUser() {

		User user = userService.getUser(command.getUserId());
		
		command.updateUser(user);

		userService.updateUser(user);

		return SUCCESS;
	}

	@RequiresPermissions("user:delete")
	public String deleteUser() {
		Assert.isTrue(userId != 1, "Cannot delete admin user");
		userService.deleteUser(userId);
		return SUCCESS;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public UserVo getCommand() {
		return command;
	}

	public void setCommand(UserVo command) {
		this.command = command;
	}

}
