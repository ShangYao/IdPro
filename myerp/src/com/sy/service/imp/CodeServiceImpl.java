package com.sy.service.imp;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


import com.sy.domain.Code;
import com.sy.service.ICodeService;
import com.sy.pub.dao.DefaultDynamicSqlDao;

public class CodeServiceImpl implements ICodeService {

	private DefaultDynamicSqlDao dynamicsqldao;
	@SuppressWarnings("unchecked")
	private static Hashtable allcode = new Hashtable();

	@SuppressWarnings("unchecked")
	@Override
	public List getCode(String type) {
		// TODO Auto-generated method stub

		if ("reload".equals(type)) {
			allcode.clear();
			init();
		}
		if (allcode.isEmpty()) {
			init();
		}
		List list = (List) allcode.get(type);
		if (list == null) {
			list = new ArrayList();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getCodeByStr(String tab, String strvalue) {
		// TODO Auto-generated method stub
		if (allcode.isEmpty()) {
			init();
		}

		List list = (List) allcode.get(tab.toUpperCase());
		String result = "";
		Code code = new Code();
		for (int i = 0; i < list.size(); i++) {
			code = (Code) list.get(i);
			String mc = code.getDescription();
			if (mc.equals(strvalue)) {
				result = code.getCode();
				break;
			}
		}
		return result;
	}
	
	
	public String getCodeByGlbmcode(String tab, String strvalue) {
		// TODO Auto-generated method stub
		if (allcode.isEmpty()) {
			init();
		}

		List list = (List) allcode.get(tab.toUpperCase());
		String result = "";
		Code code = new Code();
		for (int i = 0; i < list.size(); i++) {
			code = (Code) list.get(i);
			String glbmcode = code.getGlbmcode();
			if (glbmcode.equals(strvalue)) {
				result = code.getCode();
				break;
			}
		}
		return result;
	}
	
	
	

	@SuppressWarnings("unchecked")
	@Override
	public String getStrByCode(String tab, String codevalue) {
		// TODO Auto-generated method stub
		if (allcode.isEmpty()) {
			init();
		}
		List list = (List) allcode.get(tab.toUpperCase());
		String result = "";
		Code code = new Code();
		if (codevalue == null)
			return "";
		else
			codevalue = codevalue.trim();

		for (int i = 0; i < list.size(); i++) {
			code = (Code) list.get(i);
			String dm = code.getCode();
			if (dm.equals(codevalue)) {
				result = code.getDescription();
				break;
			}
		}
		return result;

	}

	@SuppressWarnings("unchecked")
	@Override
	public void init() {
		// TODO Auto-generated method stub
		if (allcode.isEmpty()) {
			Code code = new Code();

			List list = this.dynamicsqldao.findbyWhere(code, Code.class);
			if (list.isEmpty() == false) {
				for (int i = 0; i < list.size(); i++) {
					code = new Code();
					code = (Code) list.get(i);
					String ckey = code.getCode();
					List codelist = this.dynamicsqldao
							.findbyWhere( code, Code.class);
					allcode.put(ckey, codelist);
				}
			}
		}
	}


	@Override
	public void reload() {
		// TODO Auto-generated method stub
		allcode.clear();
		init();
	}

	@SuppressWarnings("unchecked")
	public List<Code> getcode1(String tab, String pcode) {

		if (allcode.isEmpty()) {
			init();
		}
		List list1 = new ArrayList();
		List list = (List) allcode.get(tab);
		if (list == null) {
			list = new ArrayList();
			return list;
		} else {
			if ("".equals(pcode)) {

				return list1;
			} else {
				
	               if("GLBM".equals(tab)){
	      				Code code = new Code();
	   				for (int i = 0; i < list.size(); i++) {
	   					code = (Code) list.get(i);
	   					String bmjb = code.getBmjb();
	   					if (pcode.equals(bmjb)) {
	   						list1.add(code);
	   					}
	   				}
	                  }
	               else if("QSDD".equals(tab)){
	      				Code code = new Code();
	   				for (int i = 0; i < list.size(); i++) {
	   					code = (Code) list.get(i);
	   					String xzqh = code.getXzqh();
	   					if (pcode.equals(xzqh)) {
	   						list1.add(code);
	   					}
	   				}
	                  }
	               
	               else{
				Code code = new Code();
				for (int i = 0; i < list.size(); i++) {
					code = (Code) list.get(i);
					String sjglbm = code.getGlbmcode();
					if (pcode.equals(sjglbm)) {
						list1.add(code);
					}
				}
               }

				return list1;
			}
		}

	}
	
	
	public DefaultDynamicSqlDao getDynamicsqldao() {
		return dynamicsqldao;
	}

	public void setDynamicsqldao(DefaultDynamicSqlDao dynamicsqldao) {
		this.dynamicsqldao = dynamicsqldao;
	}

	public static Hashtable getAllcode() {
		return allcode;
	}

	public static void setAllcode(Hashtable allcode) {
		CodeServiceImpl.allcode = allcode;
	}




}
