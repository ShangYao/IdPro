package com.sy.domain;

import java.util.ArrayList;
import java.util.List;

import com.sy.pub.dao.SqlSupport;
import com.sy.pub.domain.BuildSqlDomain;

public class Sequences extends SqlSupport {
	private String seqenceName;
	private String type;
	
	@Override
	public BuildSqlDomain getSqlAndValues(String key) {
		// TODO Auto-generated method stub
		
		BuildSqlDomain sqldomain = new BuildSqlDomain();
		List paralist = new ArrayList();
		StringBuffer sql = new StringBuffer();
		StringBuffer retSql = new StringBuffer();
		if("queryForString".equals(key)){
			if("seq".equals(this.getType())){
				if("SEQ_SYSLOGID".equals(this.seqenceName)||"SEQ_LOGID".equals(this.seqenceName)||"SEQ_ELOGID".equals(this.seqenceName)){
					sql = new StringBuffer("select  TO_CHAR(SYSDATE,'YYYYMMdd')||LPAD(TO_CHAR("+this.seqenceName+".NEXTVAL),6,'0') from dual");
				}else{
					sql = new StringBuffer("select  "+this.seqenceName+".nextval from dual");
				}
			}else if("date".equals(this.getType())){
				sql = new StringBuffer("select sysdate from dual");
			}
		}
		sqldomain.setSql(sql.toString());
		sqldomain.setObject(paralist.toArray());
		return sqldomain;
	}

	public String getSeqenceName() {
		return seqenceName;
	}

	public void setSeqenceName(String seqenceName) {
		this.seqenceName = seqenceName;
	}

	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	
}
