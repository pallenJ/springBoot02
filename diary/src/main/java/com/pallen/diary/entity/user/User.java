package com.pallen.diary.entity.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@ToString
public class User {

	@Id
	private String email;
	
	@Column(length = 50, nullable = false)
	private String name;	
	@Column
	private String password;	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user") 
	private List<Board> boardList;
	  
}
