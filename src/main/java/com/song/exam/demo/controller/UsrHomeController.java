package com.song.exam.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.exam.demo.service.MemberService;
import com.song.exam.demo.vo.Article;

@Controller
public class UsrHomeController {
	
	private MemberService memberService;
	
	public UsrHomeController(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping("/usr/member/doJoin")
	@ResponseBody 
	public String doJoin(String loginId, String loginPw, String name, String nickname, String cellphoneNo, String email) {
		
		memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);
		return "성공";
	}

}
