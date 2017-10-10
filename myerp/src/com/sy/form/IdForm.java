package com.sy.form;

import java.util.ArrayList;
import java.util.List;

import com.sy.domain.Id;
import com.sy.pub.component.BaseForm;

public class IdForm extends BaseForm {
	private Id id = new Id();
	private List cxlist = new ArrayList();
	private String id_temp;

	public String getId_temp() {
		return id_temp;
	}

	public void setId_temp(String id_temp) {
		this.id_temp = id_temp;
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public List getCxlist() {
		return cxlist;
	}

	public void setCxlist(List cxlist) {
		this.cxlist = cxlist;
	}
}
