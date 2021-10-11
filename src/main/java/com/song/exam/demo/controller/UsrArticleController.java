package com.song.exam.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.exam.demo.service.ArticleService;
import com.song.exam.demo.vo.Article;

@Controller
public class UsrArticleController {
	@Autowired
	private ArticleService articleService;


	// 액션 메서드 시작
	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public Article doAdd(String title, String body) {
		Article article = articleService.writeArticle(title, body);
		
		return article;
	}
	

	public void modifyArticle(int id, String title, String body) {
		Article article = articleService.getArticle(id);
		
		article.setTitle(title);
		article.setBody(body);	
	}
	// 액션 메서드 끝
	
	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		return articleService.getArticles();
	}
	
	@RequestMapping("/usr/article/getArticle")
	@ResponseBody
	public Object getArticleAction(int id) {		// Object를 사용한 것은 return 타입이 String과 Article 두 타입으로 가장 상위 타입인 Object를 사용
		Article article = articleService.getArticle(id);
		if (article == null) {
			return id + "번 게시물은 존재하지 않습니다.";
		}
		
		return article;
	}
	
	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {
		Article article = articleService.getArticle(id);
		
		if (article == null) {
			return id + "번 게시물이 존재하지 않습니다.";
		}
		
		articleService.deleteArticle(id);
		
		return id + "번 게시물을 삭제 하였습니다.";
	}
	
	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public String doMidify(int id, String title, String body) {
		Article article = articleService.getArticle(id);
		
		if (article == null) {
			return id + "번 게시물이 존재하지 않습니다.";
		}
		
		modifyArticle(id, title, body);
		
		return id + "번 게시물을 수정 하였습니다.";
	}





}
