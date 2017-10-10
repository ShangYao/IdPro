package com.sy.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

import com.sy.domain.Users;
import com.sy.form.LoginForm;
import com.sy.form.UserForm;
import com.sy.service.ICodeService;
import com.sy.pub.domain.Model;
import com.sy.service.IService;


public class UserManageController extends LocalController{
	private IService userManageService;
	private ICodeService codeService;
	@Override
	public Model doBusiness(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors) {
		// TODO Auto-generated method stub
		UserForm userForm = new UserForm();
		HttpSession session = request.getSession();
		LoginForm loginForm = (LoginForm)session.getAttribute("loginForm");
		/*if(loginForm != null && !"".equals(loginForm)){
			userForm.setCurrentYhjb(loginForm.getUser().getYhjb());
		}*/
		Model model = this.userManageService.processBusiness(command);
		return model;
	}

	@Override
	public Map dosetv(HttpServletRequest request, HttpServletResponse response,
			Object command, Errors errors) {
		// TODO Auto-generated method stub
		Map referenceData = new HashMap();
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("loginRight");
		referenceData.put("xzqhlist", this.codeService.getCode("XZQH"));
		referenceData.put("yhztlist", this.codeService.getCode("YHZT"));
		referenceData.put("yhjblist", this.codeService.getCode("YHJB"));
		referenceData.put("syxzlist", this.codeService.getCode("SYXZ"));
		referenceData.put("cllxlist", this.codeService.getCode("CLLX"));
		referenceData.put("glbmlist", this.codeService.getCode("GLBM"));
        return referenceData;
	}

	public IService getUserManageService() {
		return userManageService;
	}

	public void setUserManageService(IService userManageService) {
		this.userManageService = userManageService;
	}

	public ICodeService getCodeService() {
		return codeService;
	}

	public void setCodeService(ICodeService codeService) {
		this.codeService = codeService;
	}

}
