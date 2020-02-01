package com.pallen.diary.entity.user;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pallen.diary.entity.board.Board;
import com.pallen.diary.entity.user.User.UserBuilder;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user_setting")
@Getter
@AllArgsConstructor
@Builder
public class UserSetting {
	
	@Id
	private String name;
	
	@Column
	private int info_lock;
	@Column
	private String grade;

}
