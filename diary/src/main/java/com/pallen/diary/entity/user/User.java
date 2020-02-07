package com.pallen.diary.entity.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.pallen.diary.entity.board.Board;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user")
@Getter
@AllArgsConstructor
@Builder
@ToString(exclude = { "password", "boardList" })
public class User {

	@Id
	private String email;

	@Column(name = "name", length = 50, nullable = false)
	private String name;
	@Column(name = "password")
	private String password;
	@Column(name = "info_lock", nullable = false)
	@ColumnDefault(value = "0")
	private Integer infoLock;
	@Column(name = "grade", nullable = false)
	@ColumnDefault(value = "NORMAL")
	private String grade;
	
	@Column(name = "sns_reg")
	private String sns_reg;
	
	@PrePersist
	public void prePersist() {
	this.infoLock = 0;
	this.grade    = "NORMAL";
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	private List<Board> boardList;

}
