package com.sy.domain;

import java.util.ArrayList;
import java.util.List;

import com.sy.annotation.SDGAColumn;
import com.sy.annotation.SDGATable;
import com.sy.pub.dao.SqlSupport;
import com.sy.pub.domain.BuildSqlDomain;
@SDGATable(name="fee_role_rights")
public class RoleRelateRight extends SqlSupport {
	@SDGAColumn(primaryKey=true)
	private String role_code  ;
	@SDGAColumn(primaryKey=true)
	private String right_code  ;

	@Override
	public BuildSqlDomain getSqlAndValues(String key) {
		// TODO Auto-generated method stub
		BuildSqlDomain  sqldomain=new BuildSqlDomain();
		List<String> paralist = new ArrayList<String>();
		StringBuffer sql = new StringBuffer();
		if("findbyWhere".equals(key)){
			sql = new StringBuffer(
			" select b.* from role_rights a left join rights b on a.right_code=b.right_code where a.role_code=?  ");
			paralist.add(this.role_code);
		}else if("deleteByWhere".equals(key)){
			sql= new StringBuffer(" delete from fee_role_rights where jsdh=?  ");
		}
		sqldomain.setSql(sql.toString());
		sqldomain.setObject(paralist.toArray());
		return sqldomain;
	}

	public String getRole_code() {
		return role_code;
	}

	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}

	public String getRight_code() {
		return right_code;
	}

	public void setRight_code(String right_code) {
		this.right_code = right_code;
	}

	

}
