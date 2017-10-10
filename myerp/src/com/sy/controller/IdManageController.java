package com.sy.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

import com.sy.form.IdForm;
import com.sy.pub.domain.Model;
import com.sy.service.ICodeService;
import com.sy.service.IService;

public class IdManageController extends LocalController {
	private IService idManageService;
	private ICodeService codeService;

	public ICodeService getCodeService() {
		return codeService;
	}

	public void setCodeService(ICodeService codeService) {
		this.codeService = codeService;
	}

	public IService getIdManageService() {
		return idManageService;
	}

	public void setIdManageService(IService idManageService) {
		this.idManageService = idManageService;
	}

	@Override
	public Model doBusiness(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors) {
		// TODO Auto-generated method stub
		IdForm idForm = (IdForm) command;
		Model model = this.idManageService.processBusiness(idForm);
		return model;
	}

	@Override
	public Map dosetv(HttpServletRequest request, HttpServletResponse response,
			Object command, Errors errors) {
		// TODO Auto-generated method stub
		return null;
	}

}
