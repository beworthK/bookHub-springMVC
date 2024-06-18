package com.reese.domain;

import lombok.Data;

@Data
public class BookVO {
	
	// book tb
	private int book_id;
	private String ctgr_id;
	private String ctgr_nm;
	private String title;
	private String author;
	private String pub_nm;
	private String pub_dt;
	private int attach_no;
	private String append_yn;
	private String viewer_yn;
	
	private String reg_userId;
	private String reg_dt;
	private String mod_userId;
	private String mod_dt;
	private String del_yn;
	private String del_userId;
	private String del_dt;
	
	// param
	
	
}
