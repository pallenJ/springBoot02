package com.pallen.diary.entity.board;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "board")
@Getter
@Setter
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
	@Setter
	@Column(name = "title")
	private String title;
	@Column(name = "content")
	private String content;
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "reg_date")
	private String reg_date;
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date")
	private String update_date;
	@Column(name = "ip_address")
	private String ip_address;
	@Column(name = "state")
	private String state;
	
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
		//this.reg_date = timeFormat();
		//this.update_date = this.reg_date;
		setDates();
		this.state = "NORMAL";
	}
	
//	public String timeFormat() {
//		long time = System.currentTimeMillis(); 
//		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		return dayTime.format(new Date(time));
//	}
	/*
	 * private LocalDateTime now() { return LocalDateTime.now().plusHours(9L); }
	 */
	public void setUpdate_date() {
		//this.update_date = timeFormat();
		this.update_date =  LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd hh:mm:ss"));
	}
	public void setDates() {
		this.reg_date    =  LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd hh:mm:ss"));;
		this.update_date = this.reg_date;
	}
	
	
}
