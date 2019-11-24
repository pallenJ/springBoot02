package com.example.bootweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@MapperScan("com.example.bootweb.mapper")
@ComponentScans(
		{
			@ComponentScan("com.example.bootweb.service"),
		}
)
public class Bootweb0Application {

	public static void main(String[] args) {
		SpringApplication.run(Bootweb0Application.class, args);
	}

}
