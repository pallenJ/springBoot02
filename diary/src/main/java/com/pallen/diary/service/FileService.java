package com.pallen.diary.service;

import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.pallen.diary.entity.board.UploadFile;

public interface FileService {
	
	public UploadFile storeFile(MultipartFile file);
	public Iterable<UploadFile> getFileList();
	public Optional<UploadFile> getUploadFile(int id);
}
