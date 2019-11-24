package com.example.bootweb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReplyVO {
	
	private int hrno;
	private int rno;
	private int bno;
	private String writer;
	private String content;
	private String regDate;
	private String updateDate;
	private String ip_address;
	private String state = "NORMAL";
	
	public ReplyVO(int bno, String writer, String content) {
		super();
		this.bno = bno;
		this.writer = writer;
		this.content = content;
	}

	public ReplyVO(int bno, String writer, String content, String state) {
		super();
		this.bno = bno;
		this.writer = writer;
		this.content = content;
		this.state = state;
	}
	
	
	
}
