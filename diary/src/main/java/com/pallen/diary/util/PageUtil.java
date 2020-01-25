package com.pallen.diary.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageUtil {

	public static <T> List<T> pageToList(Page<T> pages){
		List<T> rsList = new ArrayList<>();
		pages.forEach(e->rsList.add(e));
		return rsList;
	}
	
}
