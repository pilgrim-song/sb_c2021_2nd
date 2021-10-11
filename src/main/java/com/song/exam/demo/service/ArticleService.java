package com.song.exam.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.song.exam.demo.vo.Article;

@Service
public class ArticleService {
	// 인스턴스 변수 시작
	private int articlesLastId;
	private List<Article> articles;
	// 인스턴스 변수 끝

	// 생성자
	public ArticleService() {
		articlesLastId = 0;
		articles = new ArrayList<>();
		
		// 프로그램 시작하자마자 데이터 생성(생성자에 포함되어서)
		makeTestData();
	}

	// 서비스 메서드 시작
	public void makeTestData() {
		for (int i = 1; i <= 10; i++) {
			String title = "제목" + i;
			String body = "내용" + i;

			writeArticle(title, body);
		}
	}

	public Article writeArticle(String title, String body) {
		int id = articlesLastId + 1;
		Article article = new Article(id, title, body);

		articles.add(article);
		articlesLastId = id;

		return article;
	}

	public Article getArticle(int id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}
		return null;
	}

	public void deleteArticle(int id) {
		Article article = getArticle(id);

		articles.remove(article);
	}
	// 서비스 메서드 끝

	public List<Article> getArticles() {
		return articles;
	}

}
