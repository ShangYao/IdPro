package com.sy.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.sy.pub.domain.Model;

@SuppressWarnings("deprecation")
public abstract class LocalController extends SimpleFormController {
	/*
	 *重写spring中onsubmit方法，实现用post get方式提交，转发
	  */
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		// TODO Auto-generated method stub
		// 执行业务 返回model
		request.setCharacterEncoding("UTF-8");
		Model m = doBusiness(request, response, command, errors);
		if (m == null) {
			return null;
		} else {
			ModelAndView modelAndView = new ModelAndView();
			   Map  mp=	referenceData(request, command, errors);
			   if(mp!=null){
				   modelAndView.addAllObjects(mp);
			   }
			modelAndView.setViewName(m.getViewname());
			modelAndView.addObject(this.getCommandName(), m.getModel());
			return modelAndView;
		}
	}
	
	/*
	 *重写spring中isFormSubmission方法，post、get方式都适用
	  */
	@Override
	protected boolean isFormSubmission(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return true;
	}
	
	/*
	 *重写spring中referenceData方法， 实现error时直接showform时加载页面中的数据（下拉菜单等）
	  */
	@Override
	protected Map referenceData(HttpServletRequest request, Object command,
			Errors errors) throws Exception {
		// TODO Auto-generated method stub
		HttpServletResponse response=null;
		BindException errors1=null;
		return dosetv(request,response,command,errors1);
	}
	
	/*
	 * 实现业务处理方法，返回model
	  */
	public abstract Model doBusiness(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors);
	/*
	 * 实现页面加载数据list，与bean脱离
	  */
public abstract Map dosetv(HttpServletRequest request,
		HttpServletResponse response, Object command, Errors errors);
}
