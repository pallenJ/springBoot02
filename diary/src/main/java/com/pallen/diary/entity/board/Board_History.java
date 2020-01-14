package com.pallen.diary.entity.board;

import java.time.LocalDateTime;

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
	
	@ManyToOne
	@JoinColumn(name = "bno")
	private Board original;

	@Column(name = "board_kind")
	private int board_kind;
	@Column(name = "title")
	private String title;
	@Column(name = "content")
	private String content;
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "reg_date")
	private LocalDateTime reg_date;
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date")
	private LocalDateTime update_date;
	@Column(name = "ip_address")
	private String ip_address;
	@Column(name = "state")
	private String state;
	@Column(name = "writer_email")
	private String writer_email;
	
	public void setting(int board_kind, String title, String content, LocalDateTime reg_date,
			LocalDateTime update_date, String ip_address, String state, User user) {
		this.board_kind = board_kind;
		this.title = title;
		this.content = content;
		this.reg_date = reg_date;
		this.update_date = update_date;
		this.ip_address = ip_address;
		this.state = state;
		this.writer_email = user.getEmail();
	}
	public void setting(Board brd) {
		setting(brd.getBoard_kind(), brd.getTitle(), brd.getContent(), 
				brd.getReg_date(), brd.getUpdate_date(), 
				brd.getIp_address(), brd.getState(), brd.getUser());
	}
	
	
}
