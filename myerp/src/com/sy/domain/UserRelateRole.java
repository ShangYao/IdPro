package com.sy.domain;

import java.util.ArrayList;
import java.util.List;

import com.sy.annotation.SDGAColumn;
import com.sy.annotation.SDGATable;
import com.sy.pub.dao.SqlSupport;
import com.sy.pub.domain.BuildSqlDomain;
@SDGATable(name="fee_user_roles")
public class UserRelateRole extends SqlSupport {
	@SDGAColumn(primaryKey=true)
	private String user_code ;
	@SDGAColumn(primaryKey=true)
	private String role_code ;


	@Override
	public BuildSqlDomain getSqlAndValues(String key) {
		// TODO Auto-generated method stub
		BuildSqlDomain  sqldomain=new BuildSqlDomain();
		List<String> paralist = new ArrayList<String>();
		StringBuffer sql = new StringBuffer();
		if("findbyWhere".equals(key)){
			sql = new StringBuffer(
			" select a.role_code,b.user_code from roles a,user_roles b where a.role_code=b.role_code  ");
			 if (!"".equals(this.getUser_code()) && this.getUser_code()!=null) {
				 sql.append(" and user_code=?");
				 paralist.add(this.user_code);
			 }
		}
		else if("deleteByWhere".equals(key)){
			sql= new StringBuffer(" delete from fee_user_roles where 1=1  ");
			
		}
		sqldomain.setSql(sql.toString());
		sqldomain.setObject(paralist.toArray());
		return sqldomain;
	}


	public String getUser_code() {
		return user_code;
	}


	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}


	public String getRole_code() {
		return role_code;
	}


	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}

	


}
