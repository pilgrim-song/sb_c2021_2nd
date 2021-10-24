package com.song.exam.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.exam.demo.service.ArticleService;
import com.song.exam.demo.util.Ut;
import com.song.exam.demo.vo.Article;
import com.song.exam.demo.vo.ResultData;

@Controller
public class UsrArticleController {
	private ArticleService	articleService;
	
	public UsrArticleController(ArticleService	articleService) {
		this.articleService = articleService;
	}
	
	// 액션 메서드 시작
	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public ResultData<Article> doAdd(HttpSession httpSession, String title, String body) {
		
		boolean isLogined = false;
		int loginedMemberId = 0;
		
		if (httpSession.getAttribute("loginedMemberId") != null) {
			isLogined = true;
			loginedMemberId = (int)httpSession.getAttribute("loginedMemberId");
		}
		if (isLogined == false) {
			return ResultData.from("F-A", "로그인 후 이용해 주세요.");
		}
		if (Ut.empty(title)) {
			return ResultData.from("F-1", "title(을)를 입력해주세요.");
		}
		if (Ut.empty(body)) {
			return ResultData.from("F-2", "body(을)를 입력해주세요.");
		}
		
		// 생성된 데이터는
		// S-1
		// 4번 게시물이 생성되었습니다
		// 4번
		ResultData<Integer> writeArticleRd = articleService.writeArticle(loginedMemberId, title, body);
		int id = writeArticleRd.getData1();
		
		Article article = articleService.getArticle(id);
		
		return ResultData.newData(writeArticleRd, "article", article);
	}
	
	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public ResultData<List<Article>> getArticles() {
		List<Article> articles =  articleService.getArticles();
		
		return ResultData.from("S-1", "게시물 리스트 입니다.", "articles", articles);
	}
	
	@RequestMapping("/usr/article/getArticle")
	@ResponseBody
	public ResultData<Article> getArticle(int id) {
		Article article = articleService.getArticle(id);
		
		if (article == null) {
			//return id +"번 게시물은 존재하지 않습니다.";
			return ResultData.from("F-1", Ut.f("%d번 게시물이 존재하지 않습니다.", id));
		}
		
		return ResultData.from("S-1", Ut.f("%d번 게시물 입니다.", id), "article", article);
	}
	
	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public ResultData<Integer> doDelete(HttpSession httpSession, int id) {
		boolean isLogined = false;
		int loginedMemberId = 0;
		
		if (httpSession.getAttribute("loginedMemberId") != null) {
			isLogined = true;
			loginedMemberId = (int) httpSession.getAttribute("loginedMemberId");
		}
		
		if (isLogined == false) {
			return ResultData.from("F-A", "로그인 후 이용해 주세요");
		}
		
		Article article = articleService.getArticle(id);
		
		if (article.getMemberId() != loginedMemberId) {
			return ResultData.from("F-2", "권한이 없습니다.");
		}
		
		if (article == null) {
			return ResultData.from("F-1", Ut.f("%d번 게시물이 존재하지 않습니다.", id));
		}
		
		articleService.delete(id);
		return ResultData.from("S-1", Ut.f("%d번 게시물을 삭제하였습니다.", id), "id", id);
	}
	
	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public ResultData<Article> doModify(HttpSession httpSession, int id, String title, String body) {
		boolean isLogined = false;
		int loginedMemberId = 0;
		
		if (httpSession.getAttribute("loginedMemberId") != null) {
			isLogined = true;
			loginedMemberId = (int) httpSession.getAttribute("loginedMemberId");
		}
		
		if (isLogined == false) {
			return ResultData.from("F-A", "로그인 후 이용해 주세요");
		}
		
		Article article = articleService.getArticle(id);
		
		if (article == null) {
			return ResultData.from("F-1", Ut.f("%d번 게시물이 존재하지 않습니다.", "id", id));
		}
		
		ResultData actorCanModifyRd =articleService.actorCanModify(loginedMemberId, article);	// loginedMemberId가 article를 수정할 수 있다
		
		if(actorCanModifyRd.isFail()) {
			return actorCanModifyRd;
		}
		
		return articleService.modifyArticle(id, title, body);
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
