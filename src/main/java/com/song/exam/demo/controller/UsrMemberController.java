package com.song.exam.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.exam.demo.service.MemberService;
import com.song.exam.demo.util.Ut;
import com.song.exam.demo.vo.Member;
import com.song.exam.demo.vo.ResultData;

@Controller
public class UsrMemberController {

	private MemberService memberService;
	
	public UsrMemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping("/usr/member/doJoin")
	@ResponseBody 
	public ResultData<Member> doJoin(String loginId, String loginPw, String name, String nickname, String cellphoneNo, String email) {
		
		if (Ut.empty(loginId)) {
			return ResultData.from("F-1", "loginId(을)를 입력해주세요.");
		}
		if (Ut.empty(loginPw)) {
			return ResultData.from("F-1", "loginPw(을)를 입력해주세요.");
		}
		if (Ut.empty(name)) {
			return ResultData.from("F-1", "name(을)를 입력해주세요.");
		}
		if (Ut.empty(nickname)) {
			return ResultData.from("F-1", "nickname(을)를 입력해주세요.");
		}
		if (Ut.empty(cellphoneNo)) {
			return ResultData.from("F-1", "cellphoneNo(을)를 입력해주세요.");
		}
		if (Ut.empty(email)) {
			return ResultData.from("F-1", "email(을)를 입력해주세요.");
		}
		
		// joinRd 값에 들어 있는 것은 3개다
		// S-1
		// 회원가입이 완료되었습니다.
		// 번호 : 7, 8 번 등
		ResultData<Integer> joinRd = memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);
		
		if (joinRd.isFail()) {
			return (ResultData)joinRd;
		}

		Member member = memberService.getMemberById(joinRd.getData1());
		
		return ResultData.newData(joinRd, "member", member);		// 위에서 'S-1', '회원가입이 완료되었습니다.' 는 그대로 사용하고 '번호' 를 바꾸고 싶어서 : 기존 보고서(joinRd)에 데이터를 이것만(member) 바꿔서 한다
	}
	
	@RequestMapping("/usr/member/doLogout")
	@ResponseBody 
	public ResultData doLogout(HttpSession httpSession) {
		boolean isLogined = false;
		
		if (httpSession.getAttribute("loginedMemberId") == null) {
			isLogined = true;
		}
		if (isLogined) {
			return ResultData.from("S-1", "이미 로그아웃 상태입니다.");
		}
		
		httpSession.removeAttribute("loginedMemberId");
		
		return ResultData.from("S-2", "로그아웃 되었습니다.");
	}
	
	@RequestMapping("/usr/member/doLogin")
	@ResponseBody 
	public ResultData doLogin(HttpSession httpSession, String loginId, String loginPw) {
		boolean isLogined = false;
		
		if (httpSession.getAttribute("loginedMemberId") != null) {
			isLogined = true;
		}
		if (isLogined) {
			return ResultData.from("F-5", "이미 로그인 되었습니다.");
		}
		
		if (Ut.empty(loginId)) {
			return ResultData.from("F-1", "loginId(을)를 입력해주세요.");
		}
		if (Ut.empty(loginPw)) {
			return ResultData.from("F-1", "loginPw(을)를 입력해주세요.");
		}
		
		// joinRd 값에 들어 있는 것은 3개다
		// S-1
		// 회원가입이 완료되었습니다.
		// 번호 : 7, 8 번 등
		Member member = memberService.getMemberByLoginId(loginId);
		
		if (member == null) {
			return ResultData.from("F-3", "존재하지 않은 로그인아이디 입니다.");
		}

		if (member.getLoginPw().equals(loginPw) == false) {
			return ResultData.from("F-4", "비밀번호가 일치하지 않습니다.");
		}
		
		httpSession.setAttribute("loginedMemberId", member.getId());
		
		return ResultData.from("S-1", Ut.f("%s님 환영하니다.", member.getNickname()));
	}

}
