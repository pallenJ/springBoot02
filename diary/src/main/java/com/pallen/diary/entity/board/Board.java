package com.pallen.diary.entity.board;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pallen.diary.entity.user.User;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "board")
@Getter
@AllArgsConstructor
@Builder
@ToString
public class Board {
	
	@Id
	@Column(name = "bno")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bno;
	
	@Column(name = "board_kind")
	private int board_kind;
	@Column(name = "title")
	private String title;
	@Column(name = "content")
	private String content;
	@Column(name = "reg_date")
	private String reg_date;
	@Column(name = "update_date")
	private String update_date;
	@Column(name = "ip_address")
	private String ip_address;
	
	
	@ManyToOne
	@JoinColumn(name="writer_email")
	private User user;


	public Board(int board_kind, String title, String content, String ip_address, User user) {
		super();
		this.board_kind = board_kind;
		this.title = title;
		this.content = content;
		this.ip_address = ip_address;
		this.user = user;
	}
	
	
}
