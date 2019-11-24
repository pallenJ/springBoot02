package com.example.bootweb.domain;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor
public class Criteria {
	
	protected @Setter int max = -1;
	protected int pageNum;
	protected int amount;
	protected int limit;
	private @Setter String state = "NORMAL";
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		setLimit();
	}
	public Criteria(int pageNum, int amount, int max) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.max=max;
		setLimit();
	}
	public Criteria(int pageNum, int amount,String state) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.state =state;
		setLimit();
	}
	public Criteria(int pageNum, int amount, int max,String state) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.max=max;
		this.state =state;
		setLimit();
	}
	
	public void setLimit() {
		this.limit = this.amount * (this.pageNum-1);
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		setLimit();
	}
	public void setAmount(int amount) {
		this.amount = amount;
		setLimit();
	}
	
}
