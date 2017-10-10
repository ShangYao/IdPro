package com.sy.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author lhy
 * 
 *         更改所生成类型注释的模板为 窗口 > 首选项 > Java > 代码生成 > 代码和注释
 *         ----生成主页登录后左侧权限的显示标签---------
 */
public class LeftQx extends TagSupport {
	private static final long serialVersionUID = -8482227259710041748L;
	private String leftqxcode;
	private String leftqxdes; 
	private String leftMcode;
	private String leftMdes;
    private String dis;

	/*
	 * （非 Javadoc）
	 * 
	 * @see javax.servlet.jsp.tagext.Tag#doEndTag()
	 */
	public int doEndTag() throws JspException {
		try {

			String n = leftqxcode;//权限code
			String m = leftqxdes;//权限描述
			String w = leftMcode;//菜单code
			String q = leftMdes;//菜单描述
			String d=dis;
			String[] code = n.split(",");
			String[] yhqx = m.split(",");
			String[] mcode = w.split(",");
			String[] mdes = q.split(",");
			if (!"".equals(n) && !"".equals(m) && !"".equals(w)
					&& !"".equals(q)) {
				if (code.length > 0 && yhqx.length > 0 && mcode.length > 0
						&& mdes.length > 0) {
					
					StringBuffer pagestr = new StringBuffer();
					pagestr.append("<ul class=\"menu\"> ");
					for (int l = 0; l < mcode.length; l++) {
						pagestr.append("<li class=\"certain\"><a id=\""+mcode[l]+"\" class='menufont'/>"+mdes[l]+"</a></li>" +
								"<ul class=\""+mcode[l]+"\">");
						for (int j = 0; j < code.length; j++) {
							if (code[j].substring(0, 2).equals(mcode[l])) {
								pagestr.append("<li>");
								pagestr.append("<a class='menufont' href='"+d+".do?ywtype="
												+ code[j].substring(2)
												+ "&zl="+code[j]+"'>");
								pagestr.append(yhqx[j]);
								pagestr.append("</a></li>");
							}
						}
						pagestr.append("</ul>");
					}
					pagestr.append("</ul>");
					pageContext.getOut().write(pagestr.toString());
				} else {
					pageContext.getOut().write("权限有问题");
				}
			} else {
				pageContext.getOut().write("权限为空值，请核查用户信息");
			}

		} catch (Exception e) {
			throw new JspException("加载权限出错!");
		}

		return EVAL_PAGE;
	}

	public String getLeftqxcode() {
		return leftqxcode;
	}

	public void setLeftqxcode(String leftqxcode) {
		this.leftqxcode = leftqxcode;
	}

	public String getLeftqxdes() {
		return leftqxdes;
	}

	public void setLeftqxdes(String leftqxdes) {
		this.leftqxdes = leftqxdes;
	}

	public String getLeftMcode() {
		return leftMcode;
	}

	public void setLeftMcode(String leftMcode) {
		this.leftMcode = leftMcode;
	}

	public String getLeftMdes() {
		return leftMdes;
	}

	public void setLeftMdes(String leftMdes) {
		this.leftMdes = leftMdes;
	}
	
    
	public String getDis() {
		return dis;
	}

	public void setDis(String dis) {
		this.dis = dis;
	}

}
