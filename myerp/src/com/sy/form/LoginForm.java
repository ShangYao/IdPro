package com.sy.form;

import java.util.ArrayList;
import java.util.List;

import com.sy.domain.Right;
import com.sy.domain.Users;
import com.sy.domain.Roles;
import com.sy.pub.component.BaseForm;

public class LoginForm extends BaseForm {
	private Users user=new Users();
	private Roles role=new Roles();
	private String ip;
	private String qxcode = ""; // 大码表
	private String qxdes = ""; // 小码表
	private String leftqxcode = ""; // 大码表
	private String leftqxdes = ""; // 小码表
	private String qxcode2 = ""; // 大码表
	private String qxdes2 = ""; // 小码表
	private String qxjson;
	private List<Roles> Roles = new ArrayList<Roles>();
	private List<Right> Rights = new ArrayList<Right>();


	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getQxcode() {
		return qxcode;
	}

	public void setQxcode(String qxcode) {
		this.qxcode = qxcode;
	}

	public String getQxdes() {
		return qxdes;
	}

	public void setQxdes(String qxdes) {
		this.qxdes = qxdes;
	}

	public String getLeftqxcode() {
		return leftqxcode;
	}

	public void setLeftqxcode(String leftqxcode) {
		this.leftqxcode = leftqxcode;
	}

	public String getLeftqxdes() {
		return leftqxdes;
	}

	public void setLeftqxdes(String leftqxdes) {
		this.leftqxdes = leftqxdes;
	}

	public String getQxcode2() {
		return qxcode2;
	}

	public void setQxcode2(String qxcode2) {
		this.qxcode2 = qxcode2;
	}

	public String getQxdes2() {
		return qxdes2;
	}

	public void setQxdes2(String qxdes2) {
		this.qxdes2 = qxdes2;
	}

	public String getQxjson() {
		return qxjson;
	}

	public void setQxjson(String qxjson) {
		this.qxjson = qxjson;
	}

	

	public List<Right> getRights() {
		return Rights;
	}

	public void setRights(List<Right> rights) {
		Rights = rights;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public List<Roles> getRoles() {
		return Roles;
	}

	public void setRoles(List<Roles> roles) {
		Roles = roles;
	}
}
