package com.pallen.diary.entity.board;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "board_history")
@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Board_History {
	
	@Id
	@Column(name = "hbno")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long hbno;
	
	//@ManyToOne
	@Column(name = "bno")
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
	@Column(name = "state")
	private String state;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="writer_email")
	private User user;
	
	public Board_History(Board brd) {
		setting(brd);
	}
	
	public void setting(Long bno,int board_kind, String title, String content, String reg_date,
			String update_date, String ip_address, String state, User user) {
		this.bno = bno;
		this.board_kind = board_kind;
		this.title = title;
		this.content = content;
		this.reg_date = reg_date;
		this.update_date = update_date;
		this.ip_address = ip_address;
		this.state = state;
		this.user = user;
	}
	public void setting(Board brd) {
		setting(brd.getBno(),brd.getBoard_kind(), brd.getTitle(), 
				brd.getContent(), brd.getReg_date(), brd.getUpdate_date(), 
				brd.getIp_address(), brd.getState(), brd.getUser());
	}
	
	public void setUpdateDate() {
		this.update_date =  LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-DD hh:mm:ss"));
	}
	
}
