package com.pallen.diary.entity.board;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
 
import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="upload_file")
public class UploadFile {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="file_name")
    private String fileName;
    
    @Column(name="size")
    private long size;
    
    @Column(name="mime_type")
    private String mimeType;
    
    @CreationTimestamp    // 입력시 시간 정보를 자동으로 입력해는 어노테이션.
    @Column(name="insert_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;
}