package com.example.bootweb.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class PagingView extends Criteria{

	protected int startPage;
	protected int endPage;
	protected boolean prev, next;
	private final int showPages = 10;
	protected int first = 1; 
	protected int last; 
	
	protected int nfirst = 1;
	protected int plast; 
	
	
	public PagingView(Criteria cri) {
		super(cri.getPageNum(),cri.getAmount(),cri.getMax());
		if(cri.getMax()<1) return;
		pageCalculate();
	}
	
	
	private void pageCalculate() {
		int last;
		int total = super.max;
		last = (int)(Math.ceil(total*1.0))/super.amount+(total%super.amount==0?0:1);
		this.endPage = (1+(this.pageNum-1)/showPages)*showPages;//pagenum이 showpages로 나눠서 떨어질경우 pageNum/showPage로 계산하면 로직에러. 나눠서 떨어질 경우에 대한 별도의 처리 필요없이 1을 뺌.
		this.startPage = this.endPage-showPages;
		
		
		this.next = endPage < last;
		this.prev = startPage !=0;
		this.endPage = this.next?this.endPage:last;
	
	}
	
	
}
