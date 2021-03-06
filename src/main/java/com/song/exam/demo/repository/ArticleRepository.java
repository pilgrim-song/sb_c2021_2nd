package com.song.exam.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.song.exam.demo.vo.Article;

//@Component
@Mapper
public interface ArticleRepository {
	
	public void writeArticle(@Param("memberId") int memberId, @Param("title") String title, @Param("body") String body);

	public Article getArticle(@Param("id") int id);

	public void delete(@Param("id") int id);

	public void modifyArticle(@Param("id") int id, @Param("title") String title, @Param("body") String body);
	
	public List<Article> getArticles();

	public int getLastInsertId();
	
	/*
	// INSERT INTO article SET regDate = NOW(), updateDate = NOW(), title = ?, body = ";
	@Insert("INSERT INTO article SET regDate = NOW(), updateDate = NOW(), title = #{title}, body = #{body}")
	public void writeArticle(@Param("title") String title, @Param("body") String body);

	// SELECT * FROM article WHERE id = ?
	@Select("SELECT * FROM article WHERE id = #{id}")
	public Article getArticle(@Param("id") int id);

	// DELETE FROM article WHERE id = ?
	@Delete("DELETE FROM article WHERE id = #{id}")
	public void delete(@Param("id") int id);

	// UPDATE article SET title = ?, body = ?, updateDate = NOW() WHERE id = ?;
	@Update("UPDATE article SET title = #{title}, body = #{body}, updateDate = NOW() WHERE id = #{id}")
	public void modify(@Param("id") int id, @Param("title") String title, @Param("body") String body);
	
	// SELECT * FROM article ORDER BY id DESC;
	@Select("SELECT * FROM article ORDER BY #{id} DESC")
	public List<Article> getArticles();

	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();
	*/
	
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
	 * private List<Article> articles; // DB??? ?????? ???????????? List??? articles??? ?????? ????????? ??????
	 * private int lastId;
	 * 
	 * public ArticleRepository() { articles = new ArrayList<>(); lastId = 0; }
	 * 
	 * public List<Article> getArticles() { return articles; }
	 * 
	 * public void makeTestData() { for (int i =1; i<=10; i++) { String title =
	 * "?????? " + i; String body = "?????? " + i;
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
