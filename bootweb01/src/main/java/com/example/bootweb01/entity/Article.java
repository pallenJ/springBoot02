package com.example.bootweb01.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Article {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "subject")
    private String subject;
    
    @Column(name = "content",length = 100000000)
    private String content;
    
    @Column(name = "reg_date")
    private Date reg_date;
}


