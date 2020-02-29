package com.pallen.diary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.pallen.diary.property.FileUploadProperties;

@SpringBootApplication
@EnableConfigurationProperties({
	FileUploadProperties.class
})
public class DiaryApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(DiaryApplication.class, args);
	}

}
