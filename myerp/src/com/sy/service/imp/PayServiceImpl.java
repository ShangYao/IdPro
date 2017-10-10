package com.sdga.service.imp;

import java.util.List;

import com.sdga.domain.Log;
import com.sdga.domain.SysInfo;
import com.sdga.domain.SysLog;
import com.sdga.form.PayForm;
import com.sdga.service.ICodeService;
import com.sdga.util.DBAccessUtil;
import com.sdgaframework.pub.component.PageData;
import com.sdgaframework.pub.dao.DefaultDynamicSqlDao;
import com.sdgaframework.pub.domain.Model;
import com.sdgaframework.pub.domain.ModelFactory;
import com.sdgaframework.service.IService;

public class PayServiceImpl implements IService {
	private DefaultDynamicSqlDao dynamicsqldao;
	private ICodeService codeService;
	private DBAccessUtil dbaccessutil;
	@Override
	public Model processBusiness(Object command) {
		// TODO Auto-generated method stub
		PayForm pay=(PayForm) command;
		String type=pay.getYwtype();
		if("pay".equals(type)||"log".equals(type)||"ywlog".equals(type)){
			return ModelFactory.createModel(pay, type);
		}else if("pay_cx".equals(type)){
			return payQuery(pay);
		}else if("pay_tj".equals(type)){     	//支付参数设置--添加 跳转页面     
			return ModelFactory.createModel(pay, "pay_tj");
		}else if("pay_xg".equals(type)){     	//支付参数设置--修改跳转页面
			return interfaceChange(pay);
		}
		else if("pay_sc".equals(type)){     	//支付参数设置--删除
			return interfaceDelete(pay);
		}
		else if("pay_xq".equals(type)){      	//支付参数设置--详情
			return Xq(pay);
		}
		else if("pay_insert".equals(type)){    	//支付参数设置--添加保存      
			return insertjkxx(pay);
			
		}else if("pay_update".equals(type)){   		 //支付参数设置--修改保存
			return updatejkxx(pay);
		}else if("log_cx".equals(type)){    	//支付参数设置--添加保存      
			return logcx(pay);
		}
	else if("ywlog_cx".equals(type)){    	//支付参数设置--添加保存      
		return ywlogcx(pay);
	}
		return null;
	}
	//ywlog--查询
	private Model ywlogcx(PayForm pay){
		Log sys=pay.getLog();
		long n = this.dynamicsqldao.queryForLongBynamicSql(sys);
		if(n!=0){
			PageData pagedata=new PageData(n,sys.getItemCountPerPage(),sys.getPageNumber());
			sys.setPagadata(pagedata);
			List<Log> ls = this.dynamicsqldao.findbyWhere(sys,Log.class);
			pay.setCxlist(ls);
		}else{
			pay.setYwstate("查无数据！");
		}
		return ModelFactory.createModel(pay, "ywlog");
		
	}
	//log--查询
	private Model logcx(PayForm pay){
		SysLog sys=pay.getSysLog();
		long n = this.dynamicsqldao.queryForLongBynamicSql(sys);
		if(n!=0){
			PageData pagedata=new PageData(n,sys.getItemCountPerPage(),sys.getPageNumber());
			sys.setPagadata(pagedata);
			List<SysLog> ls = this.dynamicsqldao.findbyWhere(sys,SysLog.class);
			pay.setCxlist(ls);
		}else{
			pay.setYwstate("查无数据！");
		}
		return ModelFactory.createModel(pay, "log");
		
	}
	//支付参数设置--查询
	private Model payQuery(PayForm pay){
		SysInfo sys=pay.getPay();
		long n = this.dynamicsqldao.queryForLongBynamicSql(sys);
		if(n!=0){
			PageData pagedata=new PageData(n,sys.getItemCountPerPage(),sys.getPageNumber());
			sys.setPagadata(pagedata);
			List<SysInfo> ls = this.dynamicsqldao.findbyWhere(sys,SysInfo.class);
			pay.setCxlist(ls);
		}else{
			pay.setYwstate("查无数据！");
		}
		return ModelFactory.createModel(pay, "pay");
		
	}
///支付参数设置--修改保存
	private Model updatejkxx(PayForm pay) {         
		// TODO Auto-generated method stub
		SysInfo sys=pay.getPay();
		sys.setCzr(pay.getYhxm_l());
		sys.setCzsj(dbaccessutil.getDBDate());
		long n=this.dynamicsqldao.updateByPk(sys);
		if(n!=0){
			pay.setCznr_l(pay.getYhxm_l()+"修改支付参数，appid:"+pay.getId());
			pay.setYwstate("修改成功！");
		}
		
		return ModelFactory.createModel(pay , "pay_tj");
	}
	
    /////支付参数设置--添加保存
	private Model insertjkxx(PayForm pay) {
		// TODO Auto-generated method stub
		SysInfo sys=pay.getPay();
		SysInfo inter1=new SysInfo();
		inter1.setApp_id(sys.getApp_id());
		long n0=this.dynamicsqldao.queryForLongBynamicSql(inter1);
		if(n0!=0){
			pay.setYwstate("Appid已存在！");
		}else {
			
			sys.setCzr(pay.getYhxm_l());
			sys.setCzsj(dbaccessutil.getDBDate());
			sys.setGlbm(pay.getGlbm_l());
			
			long n=this.dynamicsqldao.insert(sys);
			if(n!=0){
				pay.setCznr_l(pay.getYhxm_l()+"设置支付参数 ，Appid:"+sys.getApp_id());
				pay.setYwstate("添加成功！");
			 }
		}
		
		return ModelFactory.createModel(pay , "pay_tj");
	}
	
      /////支付参数设置--信息详情
	private Model Xq(PayForm pay) {
		// TODO Auto-generated method stub
		SysInfo sys=pay.getPay();
		sys.setApp_id(pay.getId());
		SysInfo inter1=(SysInfo)this.dynamicsqldao.selectByPk(sys);
		pay.setPay(inter1);
		return ModelFactory.createModel(pay , "pay_xq");
	}
	
     /////支付参数设置--删除
	private Model interfaceDelete(PayForm pay) {
		// TODO Auto-generated method stub
		SysInfo sys=new SysInfo();
		sys.setApp_id(pay.getId());
		long n=this.dynamicsqldao.deleteByPk(sys);
		sys.setApp_id(null);
		if(n!=0){
			pay.setCznr_l(pay.getYhxm_l()+"删除支付参数，appid: "+pay.getId());
			pay.setYwstate("删除成功！");
			pay.setId(null);
			sys=pay.getPay();
			long n1=this.dynamicsqldao.queryForLongBynamicSql(sys);
			if(n1!=0){
				PageData pagedata=new PageData(n1,sys.getItemCountPerPage(),sys.getPageNumber());
				sys.setPagadata(pagedata);
				List ls=this.dynamicsqldao.findbyWhere(sys, SysInfo.class);
				pay.setCxlist(ls);
			}
			else{
				pay.setYwstate("没有符合条件的数据");
			}
		}
		return ModelFactory.createModel(pay , "pay");
		
	}
	
     /////支付参数信息设置--修改
	private Model interfaceChange(PayForm pay) {
		// TODO Auto-generated method stub
		SysInfo sys=new SysInfo();
		sys.setApp_id(pay.getId());
		SysInfo inter1=(SysInfo)this.dynamicsqldao.selectByPk(sys);
		pay.setPay(inter1);
		return ModelFactory.createModel(pay , "pay_tj");
	}
	
   
	
   
	
	public DefaultDynamicSqlDao getDynamicsqldao() {
		return dynamicsqldao;
	}
	public void setDynamicsqldao(DefaultDynamicSqlDao dynamicsqldao) {
		this.dynamicsqldao = dynamicsqldao;
	}
	public ICodeService getCodeService() {
		return codeService;
	}
	public void setCodeService(ICodeService codeService) {
		this.codeService = codeService;
	}
	public DBAccessUtil getDbaccessutil() {
		return dbaccessutil;
	}
	public void setDbaccessutil(DBAccessUtil dbaccessutil) {
		this.dbaccessutil = dbaccessutil;
	}
	

}
