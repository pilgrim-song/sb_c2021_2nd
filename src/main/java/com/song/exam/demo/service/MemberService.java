package com.song.exam.demo.service;

import org.springframework.stereotype.Service;

import com.song.exam.demo.repository.MemberRepository;
import com.song.exam.demo.vo.Member;

@Service
public class MemberService {	

	private MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public int join(String loginId, String loginPw, String name, String nickname, String cellphoneNo, String email) {  // 리턴하는 것이 가입된 회원의 번호이다 : int
		
		Member oldMember = getMemberByLoginId(loginId);
		
		// 로그인 아이디 중복 체크
		if (oldMember != null) {	// null이 아니면 있다 : != null
			return -1;
		}
		
		oldMember = getMemberByNameAndEmail(name, email);
				
		// 아이디+이메일 중복 체크
		if (oldMember != null) {	// null이 아니면 있다 : != null
			return -2;
		}
		
		
		memberRepository.join(loginId, loginPw, name, nickname, cellphoneNo, email);
		return memberRepository.getLastInsertId();
	}

	private Member getMemberByNameAndEmail(String name, String email) {
		return memberRepository.getMemberByNameAndEmail(name, email);
	}

	public Member getMemberByLoginId(String loginId) {
		return memberRepository.getMemberByLoginId(loginId);
	}

	public Member getMemberById(int id) {
		return memberRepository.getMemberById(id);
	}

}
