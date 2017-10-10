package com.sy.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.sy.domain.Sequences;
import com.sy.pub.dao.DefaultDynamicSqlDao;
/**
 * @author wanglining
 * @since 2017-05-27
 * @description this is a convenient util mainly 
 * providing solution about date/sequence
 * */
public class DBAccessUtil {
	private Sequences seq = new Sequences();
	private DefaultDynamicSqlDao dynamicsqldao;
	
	public String getSeq(String seqname ){
		seq.setSeqenceName(seqname);
		seq.setType("seq");
		String sequence = this.dynamicsqldao.queryForString(seq);
		return sequence;
	}
	public String getDBDate(){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		seq.setType("date");
		String date = this.dynamicsqldao.queryForString(seq);
		try {
			String returnDate = df.format(df.parse(date));
			return returnDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Sequences getSeq() {
		return seq;
	}

	public void setSeq(Sequences seq) {
		this.seq = seq;
	}

	public DefaultDynamicSqlDao getDynamicsqldao() {
		return dynamicsqldao;
	}

	public void setDynamicsqldao(DefaultDynamicSqlDao dynamicsqldao) {
		this.dynamicsqldao = dynamicsqldao;
	}
	
}
