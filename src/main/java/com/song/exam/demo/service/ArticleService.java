package com.song.exam.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.exam.demo.repository.ArticleRepository;
import com.song.exam.demo.util.Ut;
import com.song.exam.demo.vo.Article;
import com.song.exam.demo.vo.ResultData;

@Service
public class ArticleService {
	
	private ArticleRepository articleRepository;
	
	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	public ResultData<Integer> writeArticle(int memberId, String title, String body) {
		articleRepository.writeArticle(memberId, title, body);	
		int id =  articleRepository.getLastInsertId();
		
		return ResultData.from("S-1", Ut.f("%d번 게시물이 생성되었습니다.", id), "id", id);
	}

	public List<Article> getArticles() {
		return articleRepository.getArticles();
	}

	public Article getArticle(int id) {
		return articleRepository.getArticle(id);
	}

	public void delete(int id) {
		articleRepository.delete(id);
	}

	public ResultData<Article> modifyArticle(int id, String title, String body) {
		articleRepository.modifyArticle(id, title, body);
		
		Article article = getArticle(id);
		
		return ResultData.from("S-1", Ut.f("%d번 게시물을 수정하였습니다.", id), "article", article); 
	}

	public ResultData actorCanModify(int actorId, Article article) {
		if (article == null) {
			return ResultData.from("F-1", "권한이 없습니다.");
		}
		
		if (article.getMemberId() != actorId) {
			return ResultData.from("F-2",  "권한이 존재하지 않습니다.");
		}
		return ResultData.from("S-1",  "게시물 수정 가능합니다.");
	}

	/*
	 * private ArticleRepository articleRepository;
	 * 
	 * public ArticleService(ArticleRepository articleRepository) {
	 * this.articleRepository = articleRepository;
	 * 
	 * makeTestData(); }
	 * 
	 * public void makeTestData() { for (int i=1; i <=10; i++) { String title =
	 * "제목 " + i; String body = "내용" +i; writeArticle(title, body); } }
	 * 
	 * public void writeArticle(String title, String body) {
	 * articleRepository.writeArticle(title, body); }
	 * 
	 * public List<Article> getArticales() { return
	 * articleRepository.getArticales(); }
	 * 
	 * public Article getArticale(int id) { return articleRepository.getArticle(id);
	 * }
	 * 
	 * public void delete(int id) { articleRepository.delete(id); }
	 * 
	 * public void modify(int id, String title, String body) {
	 * articleRepository.modify(id, title, body); }
	 */
	
	/*
	 * private ArticleRepository articleRepository;
	 * 
	 * // 생성자 public ArticleService(ArticleRepository articleRepository) {
	 * this.articleRepository = articleRepository;
	 * 
	 * articleRepository.makeTestData(); }
	 * 
	 * public List<Article> getArticles() { return articleRepository.getArticles();
	 * }
	 * 
	 * public Article getArticle(int id) { return articleRepository.getArticle(id);
	 * }
	 * 
	 * public void deleteArticle(int id) { articleRepository.deleteArticle(id);
	 * 
	 * }
	 */
}
