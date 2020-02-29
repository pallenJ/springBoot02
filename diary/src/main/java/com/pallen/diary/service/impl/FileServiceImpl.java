package com.pallen.diary.service.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import javax.annotation.Resource;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.pallen.diary.entity.board.FileRepository;
import com.pallen.diary.entity.board.UploadFile;
import com.pallen.diary.property.FileUploadProperties;
import com.pallen.diary.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileServiceImpl implements FileService{
	
	private final Path fileLocation;
	
	   @Autowired
	    public FileServiceImpl(FileUploadProperties prop) {
	        this.fileLocation = Paths.get(prop.getUploadDir())
	                .toAbsolutePath().normalize();
	        
	        try {
	            Files.createDirectories(this.fileLocation);
	        }catch(Exception e) {
	            log.info("파일을 업로드할 디렉토리를 생성하지 못했습니다.", e);
	        }
	    }

	
	@Resource
	private FileRepository fileRepository; 
	
	@Override
	public UploadFile storeFile(MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		// TODO Auto-generated method stub
        try {
            // 파일명에 부적합 문자가 있는지 확인한다.
            if(fileName.contains(".."))
                throw new FileUploadException("파일명에 부적합 문자가 포함되어 있습니다. " + fileName);
            
            Path targetLocation = this.fileLocation.resolve(fileName);
            
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            
            UploadFile uploadFile = new UploadFile(fileName, file.getSize(), file.getContentType());
            fileRepository.save(uploadFile);
            
            return uploadFile;
        }catch(Exception e) {
            log.info("["+fileName+"] 파일 업로드에 실패하였습니다. 다시 시도하십시오.",e);
        }
		return null;
	}

	@Override
	public Iterable<UploadFile> getFileList() {
		// TODO Auto-generated method stub
        Iterable<UploadFile> iterable = fileRepository.findAll();
        
        if(null == iterable) {
            log.info("업로드 된 파일이 존재하지 않습니다.");
        }
        
        return  iterable;
	}

	@Override
	public Optional<UploadFile> getUploadFile(int id) {
		// TODO Auto-generated method stub
	       Optional<UploadFile> uploadFile = fileRepository.findById(id);
	        
	        if(uploadFile == null) {
	            log.info("해당 아이디{}로 업로드 된 파일이 존재하지 않습니다.",id);
	        }
	        return uploadFile;
	}
	
}
