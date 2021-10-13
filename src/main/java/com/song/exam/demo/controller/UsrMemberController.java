package com.song.exam.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.exam.demo.service.MemberService;
import com.song.exam.demo.vo.Article;
import com.song.exam.demo.vo.Member;

@Controller
public class UsrMemberController {

	private MemberService memberService;
	
	public UsrMemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping("/usr/member/doJoin")
	@ResponseBody 
	public Member doJoin(String loginId, String loginPw, String name, String nickname, String cellphoneNo, String email) {
		
		int id = memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);

		Member member = memberService.getMemberById(id);
		
		return member;
	}

}
