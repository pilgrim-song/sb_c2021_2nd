package com.song.exam.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.song.exam.demo.vo.Article;

//@Component
@Mapper
public interface ArticleRepository {
	
	// INSERT INTO article SET regDate = NOW(), updateDate = NOW(), title = ?, body = ";
	public void writeArticle(String title, String body);

	// SELECT * FROM article WHERE id = ?
	@Select("select * from article where id = #{id}")
	public Article getArticle(@Param("id") int id);

	// DELETE FROM article WHERE id = ?
	public void delete(int id);

	// UPDATE article SET title = ?, body = ?, updateDate = NOW() WHERE id = ?;
	public void modify(int id, String title, String body);
	
	// SELECT * FROM article ORDER BY id DESC;
	public List<Article> getArticles();
	
	/*
	 * private List<Article> articles; private int lastId;
	 * 
	 * public ArticleRepository() { lastId = 0; articles = new ArrayList<>(); }
	 * 
	 * public List<Article> getArticales() { return articles; }
	 * 
	 * public void writeArticle(String title, String body) { int id = lastId + 1;
	 * Article article = new Article(id, title, body); articles.add(article);
	 * 
	 * lastId = id; }
	 * 
	 * public Article getArticle(int id) { for (Article article : articles) { if
	 * (article.getId() == id) { return article; } } return null; }
	 * 
	 * public void delete(int id) { Article article = getArticle(id);
	 * 
	 * articles.remove(article); }
	 * 
	 * public void modify(int id, String title, String body) { Article article =
	 * getArticle(id);
	 * 
	 * article.setTitle(title); article.setBody(body); }
	 */

	/*
	 * private List<Article> articles; // DB가 없는 상태에서 List인 articles는 임시 테이블 역할
	 * private int lastId;
	 * 
	 * public ArticleRepository() { articles = new ArrayList<>(); lastId = 0; }
	 * 
	 * public List<Article> getArticles() { return articles; }
	 * 
	 * public void makeTestData() { for (int i =1; i<=10; i++) { String title =
	 * "제목 " + i; String body = "내용 " + i;
	 * 
	 * writeArticle(title, body); }
	 * 
	 * }
	 * 
	 * private void writeArticle(String title, String body) { int id = lastId + 1;
	 * Article article = new Article(id, title, body);
	 * 
	 * articles.add(article); lastId = id; }
	 * 
	 * public Article getArticles(int id) { for ( Article article : articles ) { if
	 * (article.getId() == id) { return article; } } return null; }
	 * 
	 * public void deleteArticle(int id) { Article article = getArticle(id);
	 * 
	 * articles.remove(article);
	 * 
	 * }
	 * 
	 * public Article getArticle(int id) { for (Article article : articles) { if
	 * (article.getId() == id) { return article; } } return null; }
	 */

}
