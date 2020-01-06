package com.pallen.diary.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class PagingDTO {
	

	private int page;
	private int col_cnt = 10;
	private int amount = 10;
	
	private boolean hasPrev = false;
	private boolean hasNext = false;
	
	private int pageCnt;
	
	private int startShow;//현재 페이지 네이션의 시작
	private int endShow;//현재 페이지 네이션의 끝
	
	private void setting() {
		pageCnt = (page/col_cnt)+(page%col_cnt==0?0:1);
		subSetting();
	}
	private void subSetting() {
		
		hasPrev = (amount<page);
		hasNext = (page+(pageCnt%amount)<=pageCnt);
		
		startShow = page/amount+1;
		endShow   = hasNext? (page/amount + amount):pageCnt;
		
		 
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


	public PagingDTO(int page, int col_cnt, int amount) {
		this.page = page;
		this.col_cnt = col_cnt;
		this.amount = amount;
		setting();
	}
	
	public PagingDTO(int page) {
		this.page = page;
		setting();
	}


	
	
	
	
}
