package com.sy.form;

import java.util.ArrayList;
import java.util.List;

import com.sy.domain.Right;
import com.sy.domain.Roles;
import com.sy.pub.component.BaseForm;

/**
 * @author kongxiangji
 * @since 2017-7-31 上午10:08:19
 */
public class RoleForm extends BaseForm{
	private Roles role = new Roles();
	private List<Right> rights = new ArrayList<Right>();
	private String type;
	private String sdata;
	private String ssdata;
	private String yj;
	private String ej;
	private String sj;

	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	public List<Right> getRights() {
		return rights;
	}
	public void setRights(List<Right> rights) {
		this.rights = rights;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSdata() {
		return sdata;
	}
	public void setSdata(String sdata) {
		this.sdata = sdata;
	}
	public String getSsdata() {
		return ssdata;
	}
	public void setSsdata(String ssdata) {
		this.ssdata = ssdata;
	}
	public String getYj() {
		return yj;
	}
	public void setYj(String yj) {
		this.yj = yj;
	}
	public String getEj() {
		return ej;
	}
	public void setEj(String ej) {
		this.ej = ej;
	}
	public String getSj() {
		return sj;
	}
	public void setSj(String sj) {
		this.sj = sj;
	}
}
