package com.sy.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sy.domain.Roles;
import com.sy.domain.Users;
import com.sy.pub.component.BaseForm;

/**
 * @author kongxiangji
 * @since 2017-7-31 上午10:08:06
 */
public class UserForm extends BaseForm{
	private Users user = new Users();
	private String currentYhjb;
	private String currentYhdh;
	private String xmm;
	private String qrmm;
	private String type;
	private String yhyxqz;//用户有效期至
	private String mmyxqz;
	private String ipdzq; //ip地址起
    private String ipdzz; //ip地址止
	private List<Roles> roles = new ArrayList<Roles>();
	private String[] selectRoles = new String[]{};

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getCurrentYhjb() {
		return currentYhjb;
	}

	public void setCurrentYhjb(String currentYhjb) {
		this.currentYhjb = currentYhjb;
	}

	public String getCurrentYhdh() {
		return currentYhdh;
	}

	public void setCurrentYhdh(String currentYhdh) {
		this.currentYhdh = currentYhdh;
	}

	public String getXmm() {
		return xmm;
	}

	public void setXmm(String xmm) {
		this.xmm = xmm;
	}

	public String getQrmm() {
		return qrmm;
	}

	public void setQrmm(String qrmm) {
		this.qrmm = qrmm;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	public String[] getSelectRoles() {
		return selectRoles;
	}

	public void setSelectRoles(String[] selectRoles) {
		this.selectRoles = selectRoles;
	}

	public String getYhyxqz() {
		return yhyxqz;
	}

	public void setYhyxqz(String yhyxqz) {
		this.yhyxqz = yhyxqz;
	}

	public String getMmyxqz() {
		return mmyxqz;
	}

	public void setMmyxqz(String mmyxqz) {
		this.mmyxqz = mmyxqz;
	}

	public String getIpdzq() {
		return ipdzq;
	}

	public void setIpdzq(String ipdzq) {
		this.ipdzq = ipdzq;
	}

	public String getIpdzz() {
		return ipdzz;
	}

	public void setIpdzz(String ipdzz) {
		this.ipdzz = ipdzz;
	}
}
