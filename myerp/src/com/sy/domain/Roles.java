package com.sy.domain;

import java.util.ArrayList;
import java.util.List;

import com.sy.annotation.SDGAColumn;
import com.sy.annotation.SDGATable;
import com.sy.pub.dao.SqlSupport;
import com.sy.pub.domain.BuildSqlDomain;
@SDGATable(name="fee_role")
public class Roles extends SqlSupport {
	@SDGAColumn(primaryKey=true)
	private String role_code ;//角色代号
	@SDGAColumn
	private String role_name ;//角色名称
	@SDGAColumn
	private String operation_user  ;//操作员
	@SDGAColumn(date=true)
	private String operation_time  ;//操作时间
	@Override
	public BuildSqlDomain getSqlAndValues(String key) {
		// TODO Auto-generated method stub
		BuildSqlDomain  sqldomain=new BuildSqlDomain();
		List<String> paralist = new ArrayList<String>();
		StringBuffer sql = new StringBuffer();
		StringBuffer retSql = new StringBuffer();
		if("queryForLongBynamicSql".equals(key)){
			sql = new StringBuffer(
			" select count(*)  from roles where 1=1 ");
			
		}
		else if("findbyWhere".equals(key)){
				 sql = new StringBuffer(
						" select user_code,user_name,operation_user,to_char(operation_time,'yyyy-mm-dd hh24:mi:ss')operation_time from roles where 1=1 ");
				 if (!"".equals(this.getRole_code()) && this.getRole_code()!=null) {
					 sql.append(" and user_code=?");
					 paralist.add(this.role_code);
				 }
					if (!"".equals(this.getEndRowNum()) && this.getEndRowNum() != 0) {
						if (!"".equals(this.getBeginRowNum())) {
							retSql.append("SELECT *  FROM (SELECT c.*, ROWNUM RN  FROM (");
							retSql.append(sql);
							retSql.append("  ) c) WHERE RN <= " + this.getEndRowNum()
									+ " and RN >=" + this.getBeginRowNum());
							sql=retSql;
						}
					}
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
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getOperation_user() {
		return operation_user;
	}
	public void setOperation_user(String operation_user) {
		this.operation_user = operation_user;
	}
	public String getOperation_time() {
		return operation_time;
	}
	public void setOperation_time(String operation_time) {
		this.operation_time = operation_time;
	}
	

	

}
