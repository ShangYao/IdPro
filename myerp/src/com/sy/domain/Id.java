package com.sy.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sy.annotation.SDGAColumn;
import com.sy.annotation.SDGATable;
import com.sy.pub.dao.SqlSupport;
import com.sy.pub.domain.BuildSqlDomain;

@SDGATable(name = "ID")
public class Id extends SqlSupport {
	@SDGAColumn(primaryKey = true)
	private String id_number;
	@SDGAColumn
	private String id_type;
	@SDGAColumn
	private String name;
	@SDGAColumn
	private String namespell;
	@SDGAColumn
	private String sex;
	@SDGAColumn
	private String nation;
	@SDGAColumn
	private String address;
	@SDGAColumn
	private String address_province;
	@SDGAColumn
	private String address_city;
	@SDGAColumn
	private String address_area;
	@SDGAColumn
	private Date validtime_begin;
	@SDGAColumn
	private Date validtime_end;
	@SDGAColumn
	private String issuingauthority;
	@SDGAColumn
	private String privider;
	@SDGAColumn
	private String idpicture_front;
	@SDGAColumn
	private String idpicture_back;
	@SDGAColumn
	private String isuploadcloud;
	@SDGAColumn
	private String key;

	@Override
	public BuildSqlDomain getSqlAndValues(String key) {
		// TODO Auto-generated method stub
		BuildSqlDomain sqldomain = new BuildSqlDomain();
		List<String> paralist = new ArrayList<String>();
		StringBuffer sql = new StringBuffer();
		if ("queryForLongBynamicSql".equals(key)) {
			sql = new StringBuffer(" select count(*) from id where 1=1  ");
			if (!"".equals(this.getId_number()) && this.getId_number() != null) {
				sql.append(" and id_number=?");
				paralist.add(this.id_number);
			}
			if (!"".equals(this.getName()) && this.getName() != null) {
				sql.append(" and name=?");
				paralist.add(this.name);
			}
		} else if ("findbyWhere".equals(key)) {
			sql = new StringBuffer(" select * from id where 1=1  ");
			if (!"".equals(this.getId_number()) && this.getId_number() != null) {
				sql.append(" and id_number=?");
				paralist.add(this.id_number);
			}
			if (!"".equals(this.getName()) && this.getName() != null) {
				sql.append(" and name=?");
				paralist.add(this.name);
			}
		}
		sqldomain.setSql(sql.toString());
		sqldomain.setObject(paralist.toArray());
		return sqldomain;
	}

	public String getId_number() {
		return id_number;
	}

	public void setId_number(String id_number) {
		this.id_number = id_number;
	}

	public String getId_type() {
		return id_type;
	}

	public void setId_type(String id_type) {
		this.id_type = id_type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamespell() {
		return namespell;
	}

	public void setNamespell(String namespell) {
		this.namespell = namespell;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress_province() {
		return address_province;
	}

	public void setAddress_province(String address_province) {
		this.address_province = address_province;
	}

	public String getAddress_city() {
		return address_city;
	}

	public void setAddress_city(String address_city) {
		this.address_city = address_city;
	}

	public String getAddress_area() {
		return address_area;
	}

	public void setAddress_area(String address_area) {
		this.address_area = address_area;
	}

	public Date getValidtime_begin() {
		return validtime_begin;
	}

	public void setValidtime_begin(Date validtime_begin) {
		this.validtime_begin = validtime_begin;
	}

	public Date getValidtime_end() {
		return validtime_end;
	}

	public void setValidtime_end(Date validtime_end) {
		this.validtime_end = validtime_end;
	}

	public String getIssuingauthority() {
		return issuingauthority;
	}

	public void setIssuingauthority(String issuingauthority) {
		this.issuingauthority = issuingauthority;
	}

	public String getPrivider() {
		return privider;
	}

	public void setPrivider(String privider) {
		this.privider = privider;
	}

	public String getIdpicture_front() {
		return idpicture_front;
	}

	public void setIdpicture_front(String idpicture_front) {
		this.idpicture_front = idpicture_front;
	}

	public String getIdpicture_back() {
		return idpicture_back;
	}

	public void setIdpicture_back(String idpicture_back) {
		this.idpicture_back = idpicture_back;
	}

	public String getIsuploadcloud() {
		return isuploadcloud;
	}

	public void setIsuploadcloud(String isuploadcloud) {
		this.isuploadcloud = isuploadcloud;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
