package org.apache.shiro.samples.sprhib.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.samples.sprhib.model.User;
import org.apache.shiro.samples.sprhib.service.UserService;
import org.apache.struts2.StrutsStatics;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class ShiroInterceptor implements Interceptor {
	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		// Add the current user into the request
		User currentUser = userService.getCurrentUser();
		if (currentUser != null) {
			HttpServletRequest request = (HttpServletRequest) invocation
					.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
			request.setAttribute("currentUser", currentUser);
		}

		return invocation.invoke();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
