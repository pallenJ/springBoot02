package com.example.bootweb.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMapper {

	//@Select("select now()")
	public String now();
}
