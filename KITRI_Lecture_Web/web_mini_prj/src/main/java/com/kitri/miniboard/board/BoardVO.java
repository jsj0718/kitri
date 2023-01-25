package com.kitri.miniboard.board;

import java.util.Date;

public class BoardVO {
	private int bno;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private Date bregDate;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public Date getBregDate() {
		return bregDate;
	}
	public void setBregDate(Date bregDate) {
		this.bregDate = bregDate;
	}
	
	
	
	
}
