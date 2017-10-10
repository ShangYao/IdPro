package com.sy.tag;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.sy.domain.Code;
import com.sy.service.ICodeService;
import com.sy.service.imp.CodeServiceImpl;

/**
 * @author kongxiangji
 * @since 2017-7-31 下午1:37:42
 */
public class JlSelectTag extends TagSupport {
	private static final long serialVersionUID = -8482227259710041748L;
	private String bmjb; // 部门级别
	private String glbm; // 管理部门
	private String xzqh; // 行政区划
	private String bmjb_cs;//部门级别参数
	private String glbm_cs;//管理部门参数
	private String xzqh_cs;//行政区划参数
	private int yhjb; // 用户级别
	private String domainName;
	private ICodeService codeservice = new CodeServiceImpl();

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
	 */
	public int doEndTag() throws JspException {

		try {
			String retResult;
			if (!"".equals(yhjb)) {
				//retResult = buildZhiduiSelect()+ buildXzqhSelect()+ buildDaduiSelect()
				//retResult =buildXzqhSelect()+ buildDaduiSelect()+ buildZhongduiSelect();
				retResult =buildBmjbSelect()+ buildGlbmSelect();
				pageContext.getOut().write(retResult);
			} else {
				pageContext.getOut().write("");
			}

		} catch (Exception e) {
			throw new JspException("加载级联菜单出错!");
		}

		return EVAL_PAGE;
	}



	public int getYhjb() {
		return yhjb;
	}

	public void setYhjb(int yhjb) {
		this.yhjb = yhjb;
	}

	public boolean isZhiDui() {
		return this.yhjb == 2;
	}

	public boolean isDaDui() {
		return this.yhjb == 3;
	}

	public boolean isZhongDui() {
		return this.yhjb == 4;
	}

	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	public String getXzqh_cs() {
		return xzqh_cs;
	}

	public void setXzqh_cs(String xzqhCs) {
		xzqh_cs = xzqhCs;
	}


	
	/*
	 * 构造行政区划select标签字符串
	 */
	public String buildBmjbSelect() {
		StringBuffer pagestr = new StringBuffer();// 行政区划
		String id = "bmjb";
		String title = "部门级别";
		String mbDescription = "BMJB";
		pagestr.append("" + title + "：<select name=\"" + domainName+"."+id + "\" id=\""
				+ id + "\" onchange=\"changeGlbm(\'" + id + "\')\">");
		if (this.isZhiDui()) { // 支队显示该支队下所有行政区划{
			// 取所有行政区划代码
			List<Code> ls = codeservice.getCode(mbDescription);
			pagestr.append("<option value=\"\">全部</option>");
			for (int j = 0; j < ls.size(); j++) {
				Code code = (Code) ls.get(j);

				if (this.bmjb_cs.equals(code.getCode())) {
					pagestr.append("<option value=\"" + code.getCode()
							+ "\" selected=\"selected\">"
							+ code.getDescription() + "</option>");
				}else{
					pagestr.append("<option value=\"" + code.getCode()
							+ "\" >"
							+ code.getDescription() + "</option>");
				}
			}

		} 
		else { 

			pagestr.append("<option value=\"" + bmjb
					+ "\" selected=\"selected\">"
					+ codeservice.getStrByCode(mbDescription, bmjb)
					+ "</option>");
		}
		pagestr.append("</select>");
		pagestr.append("&nbsp;");
		return pagestr.toString();

	}
	

	public String buildGlbmSelect() {
		StringBuffer pagestr = new StringBuffer();// 
		String id = "glbm";
		String title = "管理部门";
		String mbDescription = "GLBM";

		pagestr.append("" + title + "：<select name=\"" + domainName+"."+id + "\" id=\""
				+ id + "\">");
		if (this.isZhiDui()) { // 支队显示该支队下所有大队{
			List<Code> ls = codeservice.getcode1(mbDescription, bmjb_cs);
			pagestr.append("<option value=\"\">全部</option>");
			for (int j = 0; j < ls.size(); j++) {
				Code code = (Code) ls.get(j);

				if (this.glbm_cs.equals(code.getCode())) {
					pagestr.append("<option value=\"" + code.getCode()
							+ "\" selected=\"selected\">"
							+ code.getDescription() + "</option>");
				}else{
					pagestr.append("<option value=\"" + code.getCode()
							+ "\" >"
							+ code.getDescription() + "</option>");
				}
			}

		} else { // 大队或中队仅显示本大队

			pagestr.append("<option value=\"" + glbm
					+ "\" selected=\"selected\">"
					+ codeservice.getStrByCode(mbDescription, glbm)
					+ "</option>");
		}

		pagestr.append("</select>");
		pagestr.append("&nbsp;");
		return pagestr.toString();

	}

	

	public String getBmjb() {
		return bmjb;
	}



	public void setBmjb(String bmjb) {
		this.bmjb = bmjb;
	}



	public String getGlbm() {
		return glbm;
	}



	public void setGlbm(String glbm) {
		this.glbm = glbm;
	}



	public String getBmjb_cs() {
		return bmjb_cs;
	}



	public void setBmjb_cs(String bmjbCs) {
		bmjb_cs = bmjbCs;
	}



	public String getGlbm_cs() {
		return glbm_cs;
	}



	public void setGlbm_cs(String glbmCs) {
		glbm_cs = glbmCs;
	}



	public ICodeService getCodeservice() {
		return codeservice;
	}



	public void setCodeservice(ICodeService codeservice) {
		this.codeservice = codeservice;
	}



	public String getDomainName() {
		return domainName;
	}



	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}




}
