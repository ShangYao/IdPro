package com.sy.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

import com.sy.domain.Users;
import com.sy.form.LoginForm;
import com.sy.pub.domain.Model;
import com.sy.service.IService;


public class LoginController extends LocalController {
	private IService loginService;
	@Override
	public Model doBusiness(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors) {
		// TODO Auto-generated method stub
		LoginForm loginForm = (LoginForm)command;
		Model model = this.loginService.processBusiness(loginForm);
		LoginForm returnForm = (LoginForm)model.getModel();
		Users user = returnForm.getUser();
		if (user.isExist()) {
			HttpSession session = request.getSession();
			session.setAttribute("loginForm", returnForm);
		}
		return model;
	}

	@Override
	public Map dosetv(HttpServletRequest request, HttpServletResponse response,
			Object command, Errors errors) {
		// TODO Auto-generated method stub
		return null;
	}

	public IService getLoginService() {
		return loginService;
	}

	public void setLoginService(IService loginService) {
		this.loginService = loginService;
	}

}
