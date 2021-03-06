package com.song.exam.demo.service;

import org.springframework.stereotype.Service;

import com.song.exam.demo.repository.MemberRepository;
import com.song.exam.demo.util.Ut;
import com.song.exam.demo.vo.Member;
import com.song.exam.demo.vo.ResultData;

@Service
public class MemberService {	

	private MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public ResultData<Integer> join(String loginId, String loginPw, String name, String nickname, String cellphoneNo, String email) {  // 리턴하는 것이 가입된 회원의 번호이다 : int
		
		Member oldMember = getMemberByLoginId(loginId);
		
		// 로그인 아이디 중복 체크
		if (oldMember != null) {	// oldMember가 null이 아니면 있다 : != null
			return ResultData.from("F-7", Ut.f("해당 로그인 아이디(%s)는 이미 사용중입니다.", loginId));
		}
		
		oldMember = getMemberByNameAndEmail(name, email);
				
		// 아이디+이메일 중복 체크
		if (oldMember != null) {	// oldMember가 null이 아니면 있다 : != null
			return ResultData.from("F-8", Ut.f("해당 이름(%s)과 이메일(%s)는 이미 사용중입니다.", name, email));
		}		
		
		memberRepository.join(loginId, loginPw, name, nickname, cellphoneNo, email);
		int id =  memberRepository.getLastInsertId();
		
		return ResultData.from("S-1", "회원 가입이 완료되었습니다.", "id", id);
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
