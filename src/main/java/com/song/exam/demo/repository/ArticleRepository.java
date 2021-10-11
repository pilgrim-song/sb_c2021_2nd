package com.song.exam.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.song.exam.demo.vo.Article;

@Component
public class ArticleRepository {

	private List<Article> articles;		// DB가 없는 상태에서 List인 articles는 임시 테이블 역할 
	private int lastId;
	
	public ArticleRepository() {
		articles = new ArrayList<>();
		lastId = 0;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void makeTestData() {
		for (int i =1; i<=10; i++) {
			String title = "제목 " + i;
			String body = "내용 " + i;
			
			writeArticle(title, body);
		}
		
	}

	private void writeArticle(String title, String body) {
		int id = lastId + 1;
		Article article = new Article(id, title, body);
		
		articles.add(article);
		lastId = id;
	}

	public Article getArticles(int id) {
		for ( Article article : articles ) {
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

	public Article getArticle(int id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}
		return null;
	}

}
