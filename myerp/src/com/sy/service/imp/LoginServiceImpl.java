package com.sy.service.imp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;


import com.sy.domain.Right;
import com.sy.domain.RoleRelateRight;
import com.sy.domain.Roles;
import com.sy.domain.UserRelateRole;
import com.sy.domain.Users;
import com.sy.form.LoginForm;
import com.sy.service.ICodeService;
import com.sy.pub.dao.DefaultDynamicSqlDao;
import com.sy.pub.domain.ModelFactory;
import com.sy.pub.domain.Model;
import com.sy.service.IService;

public class LoginServiceImpl implements IService {

	private DefaultDynamicSqlDao dynamicsqldao;

	private ICodeService codeService;
	@Override
	public Model processBusiness(Object command) {
		// TODO Auto-generated method stub
		LoginForm loginForm = (LoginForm)command;
		String type=loginForm.getYwtype();
	    if ("dl".equals(type)) {
	    	return this.getDl(loginForm);
		}
	    else {
			return ModelFactory.createModel(loginForm, "login");
		}
	}
		
		
	private Model getDl(LoginForm loginForm){
		Users users = loginForm.getUser();
		Model model = ModelFactory.createModel(null, "");
		if (users.getUser_code() != null && !"".equals(users.getUser_code())){
			Users localUser =(Users)this.dynamicsqldao.selectByPk(users);
			if (localUser.isExist()) {
				if (localUser.passwordAuth(users.getPwd())) {
								// 给用户赋值左侧菜单及大图标
					loginForm.setUser(localUser);
					loginForm=this.getUserRights(loginForm);
					model.setViewname("main");
				} else {
					loginForm.setYwstate("用户密码不正确");
					model.setViewname("login");
				}
			} else {
					loginForm.setYwstate("用户信息不存在");
					model.setViewname("login");
			}
		}else{
			loginForm.setYwstate("用户信息不存在");
			model.setViewname("login");
		}
		model.setModel(loginForm);
		return model;
	}
		
	private LoginForm getUserRights(LoginForm loginForm) {
		// TODO Auto-generated method stub
		Users user = loginForm.getUser();
		UserRelateRole userAndRole=new UserRelateRole();
		userAndRole.setUser_code(user.getUser_code());
		List<Roles> roles = this.dynamicsqldao.findbyWhere(userAndRole, Roles.class);
		loginForm.setRoles(roles);
		Map<String,Right> haveRights = new TreeMap<String,Right>(
				/*new Comparator<String>(){ 
			   public int compare(String obj1,String obj2){ 
				    //升序排序 
				   return obj1.compareTo(obj2); 
			   } */

); 
		RoleRelateRight roleAndRight;
		for(Roles role:loginForm.getRoles()){
			roleAndRight=new RoleRelateRight();
			roleAndRight.setRole_code(role.getRole_code());
			List<Right> rights=this.dynamicsqldao.findbyWhere(roleAndRight, Right.class);
			for(Right right:rights){
				haveRights.put(right.getRight_code(), right);
			}
		}
		List<Right> allRight=new ArrayList<Right>();
		Iterator<String> it = haveRights.keySet().iterator();
		while(it.hasNext()){
			Right right=new Right();
			right=haveRights.get(it.next()  );
			allRight.add(right);
		}
		loginForm.setRights(allRight);
		loginForm=this.getMainAndLeftMenu(loginForm);
		return loginForm;
	}

	public String getTreeData(LoginForm loginForm){
		String str="";
        String[] code = loginForm.getQxcode().split(",");
        String[] codeleft = loginForm.getLeftqxcode().split(",");
        String str1="";
        str="{\"menus\": [";
        int gg=1;
        int ss=1;	
        if(code.length>=1&&code[0]!=null&&!"".equals(code[0])){
        	for (int j = 0; j < code.length; j++) {
        		str1 = str1+"{\"menuid\":\""+code[j]+"\",\"icon\":\"icon-"+code[j]+"\",\"menuname\":\""+codeService.getStrByCode("MENU", code[j])+"\",\"menus\":[";
        		for (int y = 0; y < codeleft.length; y++) {
        			if (codeleft[y].substring(0, 2).equals(code[j])) {
        				str1=str1+"{\"menuid\":\"cld"+codeleft[y]+"\",\"menuname\":\""+codeService.getStrByCode("RIGHT", codeleft[y])+"\",\"icon\":\"icon-"+codeleft[y]+"\",\"url\":\"dispatch.do?ywtype="+codeleft[y].substring(4)+"&zl="+codeleft[y]+"\"},";
        				ss++;
        			}
        		} 
        		str1=str1.substring(0,str1.length()-1);
        		str1=str1+"]},";		  
        }
        str1=str1.substring(0,str1.length()-1);
		str=str+str1+"]}";
  }
		return str;

	}
	
	
	

	private LoginForm getMainAndLeftMenu(LoginForm loginForm) {
		// TODO Auto-generated method stub
		String strcode = "";
		String strdes = "";
		String strleftcode = "";
		String strleftdes = "";
		TreeSet<String> menus = new TreeSet<String>();
		for (Right right : loginForm.getRights()) {
			strleftcode = strleftcode + right.getRight_code() + ",";
			strleftdes = strleftdes + right.getRight_name() + ",";
			menus.add(right.getMain_menu_name());
		}
		Iterator<String> it = menus.iterator();
		while (it.hasNext()) {
			String id = it.next();
			strcode = strcode + id + ",";
			strdes = strdes + codeService.getStrByCode("MENU", id) + ",";

		}
		loginForm.setQxcode(getStr(strcode));
		loginForm.setQxdes(getStr(strdes));
		loginForm.setLeftqxcode(getStr(strleftcode));
		loginForm.setLeftqxdes(getStr(strleftdes));
		loginForm.setQxjson(getTreeData(loginForm));
		return loginForm;
	}
     public String getStr(String p){
    	String ss="";
    	if (p.length() >= 1) {
			ss= p.substring(0, p.length() - 1);
		}
    	return ss;
     }


	public DefaultDynamicSqlDao getDynamicsqldao() {
		return dynamicsqldao;
	}


	public void setDynamicsqldao(DefaultDynamicSqlDao dynamicsqldao) {
		this.dynamicsqldao = dynamicsqldao;
	}


	public ICodeService getCodeService() {
		return codeService;
	}


	public void setCodeService(ICodeService codeService) {
		this.codeService = codeService;
	}
	

}
