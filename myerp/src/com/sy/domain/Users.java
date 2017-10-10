package com.sy.domain;

import com.sy.util.EncryptMD5;
import com.sy.annotation.SDGAColumn;
import com.sy.annotation.SDGATable;
import com.sy.pub.dao.SqlSupport;
import com.sy.pub.domain.BuildSqlDomain;
@SDGATable(name="USERS")
public class Users extends SqlSupport {
	@SDGAColumn(primaryKey=true)
	private String user_code;
	@SDGAColumn
	private String name;
	@SDGAColumn
	private String pwd;
	@SDGAColumn
	private String idnumber;
	@SDGAColumn
	private String department;
	@SDGAColumn
	private String state;
	@SDGAColumn(date=true)
	private String operation_time;
	@SDGAColumn
	private String operation_user;

	public boolean passwordAuth(String dlmm){
		if (dlmm != null && !"".equals(dlmm)){
			String encDlmm = EncryptMD5.MD5Encode(dlmm);
			if (encDlmm.equals(this.getPwd())){
				return true;
			}
		}
		return false;
	}
	@Override
	public BuildSqlDomain getSqlAndValues(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getOperation_time() {
		return operation_time;
	}
	public void setOperation_time(String operation_time) {
		this.operation_time = operation_time;
	}
	public String getOperation_user() {
		return operation_user;
	}
	public void setOperation_user(String operation_user) {
		this.operation_user = operation_user;
	}

	

}
