package com.sy.domain;

import java.util.ArrayList;
import java.util.List;

import com.sy.annotation.SDGAColumn;
import com.sy.annotation.SDGATable;
import com.sy.pub.dao.SqlSupport;
import com.sy.pub.domain.BuildSqlDomain;
@SDGATable(name="code")
public class Code extends SqlSupport{
	@SDGAColumn(primaryKey=true)
	private String code = "";
	@SDGAColumn
	private String description = "";
	private String glbmcode = "";
	private String xzqh = "";
	private String bmjb;
	
	@Override
	public BuildSqlDomain getSqlAndValues(String key) {
		// TODO Auto-generated method stub
		BuildSqlDomain  sqldomain=new BuildSqlDomain();
		List<String> paralist = new ArrayList<String>();
		StringBuffer sql = new StringBuffer();
		if("findbyWhere".equals(key)){
			if (this.isExist()){
				sql = new StringBuffer(" select *  "+this.description);	
			}else{
				sql = new StringBuffer(" select * from code ");
			}
		}
		else if("getCount".equals(key)){
		}
		sqldomain.setSql(sql.toString());
		sqldomain.setObject(paralist.toArray());
		return sqldomain;
	}
	
	public String getBmjb() {
		return bmjb;
	}

	public void setBmjb(String bmjb) {
		this.bmjb = bmjb;
	}

	public String getGlbmcode() {
		return glbmcode;
	}

	public void setGlbmcode(String glbmcode) {
		this.glbmcode = glbmcode;
	}

	/**
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param string
	 */
	public void setCode(String string) {
		code = string;
	}

	/**
	 * @param string
	 */
	public void setDescription(String string) {
		description = string;
	}

	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}


}
