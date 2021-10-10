package com.song.exam.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.exam.demo.vo.Article;

@Controller
public class UsrArticleController {
	private int articelsLastId;
	private List<Article> articles;
	
	public UsrArticleController() {
		articelsLastId = 0;
		articles = new ArrayList<>();
	}

	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public Article doAdd(String title, String body) {
		int id = articelsLastId + 1;
		Article article = new Article(id, title, body);
		
		articles.add(article);
		articelsLastId++;
		
		return article;
	}
	
	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		return articles;
	}
}
