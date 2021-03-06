package com.pallen.diary.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class PagingDTO {//페이지 계산을 위해 만든 클래스
	

	private int page;
	private int col_cnt = 10;
	private int amount = 5;
	
	private boolean hasPrev = false;
	private boolean hasNext = false;
	
	@Setter
	private int pageAllcnt = 100000;
	
	private int pageCnt;
	
	private int startShow;//현재 페이지네이션의 시작
	private int endShow;//현재 페이지네이션의 끝
	
	private void setting() {
		pageCnt = (pageAllcnt/col_cnt)+(pageAllcnt%col_cnt==0?0:1);
		subSetting();
	}
	private void subSetting() {
		
		hasPrev = (amount<page);
		hasNext = (page+(pageCnt%amount)<=pageCnt);
		
		startShow = ((page-1)/amount)*amount+1;
		endShow   = hasNext? (startShow- 1 + amount):pageCnt;
		
		 
	}

	public void setPage(int page) {
		this.page = page;
		subSetting();
	}
	
	public void setCol_cnt(int col_cnt) {
		this.col_cnt = col_cnt;
		setting();
	}


	public void setAmount(int amount) {
		this.amount = amount;
		setting();
	}


	public PagingDTO(int page, int col_cnt, int amount, int pageAllCnt) {
		this.page = page;
		this.col_cnt = col_cnt;
		this.amount = amount;
		this.pageAllcnt = pageAllCnt;
		setting();
	}
	public PagingDTO(int page, int col_cnt, int amount) {
		this.page = page;
		this.col_cnt = col_cnt;
		this.amount = amount;
		setting();
	}
	
	public PagingDTO(int page,int pageAllCnt) {
		this.page = page;
		this.pageAllcnt = pageAllCnt;
		setting();
	}
	public PagingDTO(int page) {
		this.page = page;
		setting();
	}
	

	
	
	
	
}
