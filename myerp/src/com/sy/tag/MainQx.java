/*
 * 创建日期 2012-3-21
 *
 * 更改所生成文件模板为
 * 窗口 > 首选项 > Java > 代码生成 > 代码和注释
 */
package com.sy.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * 
 *         更改所生成类型注释的模板为 窗口 > 首选项 > Java > 代码生成 > 代码和注释 ----生成权限的标签---------
 */
public class MainQx extends TagSupport {
	private static final long serialVersionUID = -8482227259710041748L;
	private String qxcode; // 大码表
	private String qxdes; // 小码表
	private String qxcode2; // 大码表
	private String qxdes2; // 小码表

	/*
	 * （非 Javadoc）
	 * 
	 * @see javax.servlet.jsp.tagext.Tag#doEndTag()
	 */
	public int doEndTag() throws JspException {
		try {
			String n = qxcode;
			String m = qxdes;
			String n2 = qxcode2;
			String m2 = qxdes2;
			if (!"".equals(n) && !"".equals(m)) {
				String[] code = n.split(",");
				String[] yhqx = m.split(",");
				String[] code2 = n2.split(",");
				String[] yhqx2 = m2.split(",");
				
				if (yhqx.length > 0 && code.length > 0) {
					StringBuffer pagestr = new StringBuffer();
					for (int j = 0; j < code.length; j++) {
						pagestr.append("<li>");
						pagestr.append("<a href=\"javascript:;\" name=\"menu"+code[j]+"\"><span>");
						pagestr.append(""
								+ yhqx[j] + "");
						pagestr.append("</span></a>");
						pagestr.append("</li>");
					}
					

					pageContext.getOut().write(pagestr.toString());
				} else {
					pageContext.getOut().write("权限有问题");
				}
			} else {
				pageContext.getOut().write("权限为空值，请检查用户信息");
			}

		} catch (Exception e) {

			throw new JspException("加载权限出错!");
		}

		return EVAL_PAGE;
	}

	public String getQxcode() {
		return qxcode;
	}

	public void setQxcode(String qxcode) {
		this.qxcode = qxcode;
	}

	public String getQxdes() {
		return qxdes;
	}

	public void setQxdes(String qxdes) {
		this.qxdes = qxdes;
	}

	public String getQxcode2() {
		return qxcode2;
	}

	public void setQxcode2(String qxcode2) {
		this.qxcode2 = qxcode2;
	}

	public String getQxdes2() {
		return qxdes2;
	}

	public void setQxdes2(String qxdes2) {
		this.qxdes2 = qxdes2;
	}

}
