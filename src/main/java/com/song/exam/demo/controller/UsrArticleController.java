package com.song.exam.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.exam.demo.service.ArticleService;
import com.song.exam.demo.vo.Article;

@Controller
public class UsrArticleController {
	private ArticleService	articleService;
	
	public UsrArticleController(ArticleService	articleService) {
		this.articleService = articleService;
	}
	
	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		return articleService.getArticales();
	}
	
	@RequestMapping("/usr/article/getArticle")
	@ResponseBody
	public Article getArticle(int id) {
		return articleService.getArticale(id);
	}
	
	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {
		Article article = articleService.getArticale(id);
		
		if (article == null) {
			return id +"번 게시물은 존재하지 않습니다.";
		}
		
		articleService.delete(id);
		return id +"번 게시물을 삭제 하였습니다.";
	}
	
	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public String doModify(int id, String title, String body) {
		Article article = articleService.getArticale(id);
		
		if (article == null) {
			return id +"번 게시물은 존재하지 않습니다.";
		}
		
		articleService.modify(id, title, body);
		return id +"번 게시물을 수정 하였습니다.";
	}
	/*
	 * @Autowired private ArticleService articleService;
	 * 
	 * @RequestMapping("/usr/article/getArticles")
	 * 
	 * @ResponseBody public List<Article> getArticles() { return
	 * articleService.getArticles(); }
	 * 
	 * @RequestMapping("/usr/article/getArticle")
	 * 
	 * @ResponseBody public Article getArticle(int id) { return
	 * articleService.getArticle(id); }
	 * 
	 * @RequestMapping("/usr/article/doDelete")
	 * 
	 * @ResponseBody public String doDelete(int id) { Article article =
	 * articleService.getArticle(id);
	 * 
	 * if (article == null) { return id + "번 게시물은 존재하지 않습니다."; }
	 * 
	 * articleService.deleteArticle(id);
	 * 
	 * return id + "번 게시물이 삭제되었습니다."; }
	 */
} 
