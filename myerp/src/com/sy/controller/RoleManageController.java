package com.sy.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

import com.sy.form.LoginForm;
import com.sy.form.RoleForm;
import com.sy.service.ICodeService;
import com.sy.pub.domain.Model;
import com.sy.service.IService;

/**
 * @author kongxiangji
 * @since 2017-7-31 上午11:36:21
 */
public class RoleManageController extends LocalController{
	private IService roleManageService;
	private ICodeService codeService;

	@Override
	public Model doBusiness(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors) {
		// TODO Auto-generated method stub
		RoleForm roleForm = (RoleForm)command;
		HttpSession session = request.getSession();
		LoginForm loginForm = (LoginForm)session.getAttribute("loginForm");
		if(loginForm != null && !"".equals(loginForm)){
			roleForm.setYj(loginForm.getQxcode());
//			roleForm.setEj(loginForm.getQxcode2());
			roleForm.setSj(loginForm.getLeftqxcode());
		}
		Model model = this.roleManageService.processBusiness(command);
		return model;
	}

	@Override
	public Map dosetv(HttpServletRequest request, HttpServletResponse response,
			Object command, Errors errors) {
		// TODO Auto-generated method stub
		Map referenceData = new HashMap();
		referenceData.put("jslblist", this.codeService.getCode("JSLB"));
		return referenceData;
	}


	public ICodeService getCodeService() {
		return codeService;
	}

	public void setCodeService(ICodeService codeService) {
		this.codeService = codeService;
	}

	public IService getRoleManageService() {
		return roleManageService;
	}

	public void setRoleManageService(IService roleManageService) {
		this.roleManageService = roleManageService;
	}
	
}
