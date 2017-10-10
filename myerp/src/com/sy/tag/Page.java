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
 * @author
 * 
 *         更改所生成类型注释的模板为 窗口 > 首选项 > Java > 代码生成 > 代码和注释
 */
public class Page extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8482227259710041748L;
	private long pageNumber; // 当前页
	private long lastPageNumber; // 总页数
	private long totalRecordCount; // 总记录数
    private long itemCountPerPage;//每页个数
	/*
	 * （非 Javadoc）
	 * 
	 * @see javax.servlet.jsp.tagext.Tag#doEndTag()
	 */
	public int doEndTag() throws JspException {
		try {
			StringBuffer pagestr = new StringBuffer();
			long p = pageNumber;
			long n = lastPageNumber;
			long f = 0;
			long l = 0;
			long previous = 0;
			long next = 0;
			if (p > n) {
				p = n;
			}
			pagestr.append("<div id=\"pageBar\"><div class=\"pageBarRight paging\">");
			if (n > 0) {
				if (n <= 10) {
					f = 1;
					l = n;
				} else {
					f = p - 4;
					l = p + 5;
					if (f <= 0) {
						f = 1;
						l = 10;
					}
					if (l > n) {
						f = n - 9;
						l = n;
					}
				}
				previous = p - 1;
				next = p + 1;
				pagestr.append("<div class=\"pageBarLeft\"><img src=\"images/text.gif\" align=\"absmiddle\"/>共<font color=red>" + totalRecordCount
						+ "</font>条记录，每页<font color=red>"+itemCountPerPage+"</font>条，当前第<font color=red>" + p
						+ "</font>/<font color=red>" + n
						+ "</font>页</div>");
				if (p > 1) {
					pagestr
							.append("<span><a   href=\"javascript:fy('1');\"><img src=\"images\\first.gif\"  title=\"首页\"/></a></span>");
					pagestr.append("<span><a   href=\"javascript:fy('"
							+ previous + "');\"><img src=\"images\\previous.gif\" title=\"上一页\"/></a></span>");
				}
				if (n > 1) {
					for (long k = f; k <= l; k++) {
						if (k != p) {
							pagestr.append("<span><a href=\"javascript:fy('"
									+ k + "');\">" + k + "</a></span>");
						} else {
							pagestr
									.append("<span class=\"paging_current\"><a href=\"javascript:void(0);\">"
											+ k + "</a></span>");
						}
					}

				}
				if (p < n) {
					pagestr.append("<span><a  href=\"javascript:fy('" + next
							+ "');\"><img src=\"images\\next.gif\"  title=\"下一页\"/></a></span>");
					pagestr.append("<span><a  href=\"javascript:fy('" + n
							+ "');\"><img src=\"images\\last.gif\" title=\"尾页\"/></a></span>");
				}

				
			} else {
				pagestr.append("<div class=\"pageBarLeft\"><img src=\"images/text.gif\" align=\"absmiddle\"/>【暂无查询记录】</div>");
			}
			pagestr.append("</div></div>");
			pageContext.getOut().write(pagestr.toString());
		} catch (Exception e) {

			throw new JspException("加载分页出错!");
		}

		return EVAL_PAGE;
	}

	/**
	 * @return
	 */
	public long getLastPageNumber() {
		return lastPageNumber;
	}

	/**
	 * @return
	 */
	public long getPageNumber() {
		return pageNumber;
	}

	/**
	 * @return
	 */
	public long getTotalRecordCount() {
		return totalRecordCount;
	}

	/**
	 * @param i
	 */
	public void setLastPageNumber(long i) {
		lastPageNumber = i;
	}

	/**
	 * @param i
	 */
	public void setPageNumber(long i) {
		pageNumber = i;
	}

	/**
	 * @param i
	 */
	public void setTotalRecordCount(long i) {
		totalRecordCount = i;
	}

	public long getItemCountPerPage() {
		return itemCountPerPage;
	}

	public void setItemCountPerPage(long itemCountPerPage) {
		this.itemCountPerPage = itemCountPerPage;
	}

}
