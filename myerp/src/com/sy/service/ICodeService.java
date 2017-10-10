package com.sy.service;

import java.util.List;

import com.sy.domain.Code;

/**
 * 
* <p>Title: ICodeService<／p>
* <p>Description: <／p>
* <p>Company:sdga<／p> 
* @author  zhaoliang
* @date 2014-6-12
 */
public abstract interface ICodeService {
	/**
	 * 
	* <p>Title: init<／p>
	* <p>Description:初始化codeservice <／p>
	 */
	public abstract void init();
	/**
	 * 
	* <p>Title: getCode<／p>
	* <p>Description:根据码表类型获取码表集合 <／p>
	* @param type
	* @return
	 */
	public abstract List<Code> getCode(String type);
	/**
	 * 
	* <p>Title: getStrByCode<／p>
	* <p>Description:根据码表类型和码表值获取码表描述 <／p>
	* @param tab
	* @param codevalue
	* @return
	 */
	public abstract String getStrByCode(String tab, String codevalue);
	/**
	 * 
	* <p>Title: getCodeByStr<／p>
	* <p>Description:根据码表类型和码表描述获取码表值 <／p>
	* @param tab
	* @param codevalue
	* @return
	 */
	public abstract String getCodeByStr(String tab, String strvalue);
	/**
	 * 
	* <p>Title: reload<／p>
	* <p>Description:重载码表数据 <／p>
	 */
	public abstract void reload();
	/**
	 * 
	* <p>Title: getcode1<／p>
	* <p>Description: 根据码表类型和glbmcode值获取其中的对应集合<／p>
	* @param tab
	* @param pcode
	* @return
	 */
	public List<Code> getcode1(String tab, String pcode);
	public abstract String getCodeByGlbmcode(String tab, String pcode) ;
	
}