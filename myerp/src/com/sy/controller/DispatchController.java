package com.sy.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import com.sy.pub.domain.Model;
import com.sy.pub.domain.ModelFactory;


public class DispatchController extends LocalController {
	private Map<String, String> retUrlMap = new HashMap<String, String>();
	@Override
	public Model doBusiness(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors) {
		// TODO Auto-generated method stub
		String type = request.getParameter("ywtype");
		String zl = request.getParameter("zl");
		String url="";
		if("left".equals(type)||"nav".equals(type)){
			url=retUrlMap.get(type);
		}
		else{
		url=retUrlMap.get(type)+"&zl="+zl;
		}
		if("".equals(url)||url==null){
			return ModelFactory.createModel(null, "login");
		}else{
			return ModelFactory.createModel(null, url);
		}
	}

	
	public Map<String, String> getRetUrlMap() {
		return retUrlMap;
	}

	public void setRetUrlMap(Map<String, String> retUrlMap) {
		this.retUrlMap = retUrlMap;
	}


	@Override
	public Map dosetv(HttpServletRequest request, HttpServletResponse response,
			Object command, Errors errors) {
		// TODO Auto-generated method stub
		return null;
	}
}
