package com.pallen.diary.entity.board;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "board_history")
@Getter
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

}
