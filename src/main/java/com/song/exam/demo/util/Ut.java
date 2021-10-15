package com.song.exam.demo.util;

public class Ut {

	public static boolean empty(Object obj) {  // 로그인 ID가  비어있는 것을 체크 하는 함수 // loginId == null || loginId.trim().length() == 0
		if (obj == null) {		//	null이냐? 
			return true;		// 비어있다(if문 안에 true)
		}
		
		if (obj instanceof String == false) {  // obj instanceof String : obj 객체는 String이다  // String이 아니면 : == false
			return true;																														// 비어있다 (if문 안에 true)
		}
		
		String str = (String)obj;	// 문장이더라도
		
		return str.trim().length() == 0;		// 좌우 공백을 제거하고 길이가 0이다 그러면 비어있다라고 본다
	}
	
	

}
