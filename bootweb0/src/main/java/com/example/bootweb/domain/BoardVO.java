package com.example.bootweb.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardVO {
	
	private int ebno;//수정내역용
	private int bno;
	private String title;
	private String writer;
	private String content;
	private String regDate;
	private String updateDate;
	private String ip_address;
	private String state = "NORMAL";
	private String password;
	public BoardVO(String title, String writer, String content) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
	
}
