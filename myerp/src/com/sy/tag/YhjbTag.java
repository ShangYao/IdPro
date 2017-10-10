package com.sy.tag;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.sy.domain.Code;
import com.sy.service.ICodeService;
import com.sy.service.imp.CodeServiceImpl;

/**
 * @author kongxiangji
 * @since 2017-7-31 下午2:37:12
 */
public class YhjbTag extends TagSupport {
	private static final long serialVersionUID = -8482227259710041748L;
	private String yhjb_cs;//用户级别参数
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

				retResult = buildYhjbSelect();
				pageContext.getOut().write(retResult);
			} else {
				pageContext.getOut().write("");
			}

		} catch (Exception e) {
			throw new JspException("加载级联菜单出错!");
		}

		return EVAL_PAGE;
	}
	public boolean isZongDui() {
		return this.yhjb == 2;
	}
	public boolean isZhiDui() {
		return this.yhjb == 3;
	}

	public boolean isDaDui() {
		return this.yhjb == 4;
	}

	public boolean isZhongDui() {
		return this.yhjb == 5;
	}

	/*
	 * 构造用户级别select标签字符串
	 */
	public String buildYhjbSelect() {
		StringBuffer pagestr = new StringBuffer();
		String id = "yhjb";
		String title = "用户级别";
		String mbDescription = "YHJB";

		pagestr.append("<nobr><span>"+ title + "：</span><select name=\"" + domainName+"."+id + "\" id=\""
				+ id + "\">");
		pagestr.append("<option value=\"\">全部</option>");
		if (this.isZongDui()) { 
			List<Code> ls = codeservice.getCode(mbDescription);
			
			for (int j = 0; j < ls.size(); j++) {
				Code code = (Code) ls.get(j);

				if (this.yhjb_cs.equals(code.getCode())) {
					pagestr.append("<option value=\"" + code.getCode()
							+ "\" selected=\"selected\">"
							+ code.getDescription() + "</option>");
				}else{
					pagestr.append("<option value=\"" + code.getCode()
							+ "\" >"
							+ code.getDescription() + "</option>");
				}
			}

		} else if(this.isZhiDui()){
			List<Code> ls = codeservice.getCode(mbDescription);
			//pagestr.append("<option value=\"\">全部</option>");
			for (int j = 0; j < ls.size(); j++) {
				Code code = (Code) ls.get(j);
              if(!"2".equals(code.getCode())){
				if (this.yhjb_cs.equals(code.getCode())) {
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
		}
		else if(this.isDaDui()){
			List<Code> ls = codeservice.getCode(mbDescription);
			pagestr.append("<option value=\"\">全部</option>");
			for (int j = 0; j < ls.size(); j++) {
				Code code = (Code) ls.get(j);
              if(!"2".equals(code.getCode())&&!"3".equals(code.getCode())){
				if (this.yhjb_cs.equals(code.getCode())) {
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
		}
		else { // 中队

			pagestr.append("<option value=\"" + yhjb
					+ "\" selected=\"selected\">"
					+ codeservice.getStrByCode(mbDescription, Integer.toString(yhjb))
					+ "</option>");
		}

		pagestr.append("</select></nobr>");
		return pagestr.toString();

	}

	public String getYhjb_cs() {
		return yhjb_cs;
	}

	public void setYhjb_cs(String yhjbCs) {
		yhjb_cs = yhjbCs;
	}

	public int getYhjb() {
		return yhjb;
	}

	public void setYhjb(int yhjb) {
		this.yhjb = yhjb;
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
