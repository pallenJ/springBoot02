package com.example.bootweb01.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bootweb01.entity.Article;
import com.example.bootweb01.entity.ArticleRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/article")
@Controller
public class ArticleController {
    @Resource
    private ArticleRepository articleRepository;


	@GetMapping("/write")
	public void write() {
		
	}
	
	@GetMapping(value = "/{id}")
    public String getArticle(Model model, @PathVariable long id) {
        Article article = articleRepository.getOne(id);
        model.addAttribute("article", article);
        return "/article/detail";
    }
    
    @GetMapping(value = "")
    public String getArticleList(Model model) {
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articleList", articleList);
        return "/article/list";
    }
    
    @PostMapping(value = "")
    public String setArticle(Article article) {
        article.setReg_date(new Date());
        
        log.info(article.toString());
        return "redirect:/article/" + articleRepository.save(article).getId();
    }


	
}
