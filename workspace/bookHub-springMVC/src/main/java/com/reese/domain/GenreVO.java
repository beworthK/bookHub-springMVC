package com.reese.domain;

import lombok.Data;

@Data
public class GenreVO {
	
	// genre tb
	private String genre_no;
	private String name;
	private String parent_genre;
	private int depth;
	private int depth_seq;
	private int sort_seq;
	
	private String reg_id;
	private String reg_dt;
	private String mod_userid;
	private String mod_dt;
	private String del_yn;
	private String del_userid;
	private String del_dt;
	
	// param
	private String tree;
}
