package com.pallen.diary.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pallen.diary.entity.board.UploadFile;
import com.pallen.diary.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class FileController {
	
	@Resource
	private FileService fileService;
	
	@GetMapping("/uploadFiles")
    public Iterable<UploadFile> getUploadFileList(){
        return fileService.getFileList();
    }
    
    @GetMapping("/uploadFile/{id}")
    public Optional<UploadFile> getUploadFile(@PathVariable int id){
        return fileService.getUploadFile(id);
    }
    @PostMapping("/uploadFile")
    public UploadFile uploadFile(@RequestParam("file") MultipartFile file) {
        UploadFile uploadFile = fileService.storeFile(file);
        
        return uploadFile;
    }
    
    @PostMapping("/uploadMultipleFiles")
    public List<UploadFile> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files){
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

}
