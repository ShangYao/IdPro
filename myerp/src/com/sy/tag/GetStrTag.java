
package com.sy.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.sy.service.ICodeService;
import com.sy.service.imp.CodeServiceImpl;



/**
 * @author lhy
 *
 * 更改所生成类型注释的模板为
 * 窗口 > 首选项 > Java > 代码生成 > 代码和注释
 * ----生成主页登录后左侧权限的显示标签---------
 */
public class GetStrTag extends TagSupport {
	private static final long serialVersionUID = -8482227259710041748L;
	private String  code;			//大码表
	private String  mbcode;			//大码表
	/* （非 Javadoc）
	 * @see javax.servlet.jsp.tagext.Tag#doEndTag()
	 */
	public int doEndTag() throws JspException {
		try{
			StringBuffer pagestr = new StringBuffer();
			String  n=code;
	if(!"".equals(n)){	
		ICodeService  codeservice=new CodeServiceImpl();
         String  mdes=codeservice.getStrByCode(mbcode, code);
				pagestr.append(""+mdes+"");
		     pageContext.getOut().write(pagestr.toString());
	}
	else{
		pageContext.getOut().write("");
	}
		     
		}catch(Exception e){
			try {
				pageContext.getOut().write("");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//throw new JspException("加载转换出错!");
		}
		
		return EVAL_PAGE;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMbcode() {
		return mbcode;
	}
	public void setMbcode(String mbcode) {
		this.mbcode = mbcode;
	}


}
