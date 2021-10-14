package com.song.exam.demo.util;

public class Ut {

	public static boolean empty(Object obj) {
		if (obj == null) {		//	null이냐? 
			return true;		// 비어있다
		}
		
		if (obj instanceof String == false) {  // obj instanceof String : obj 객체는 String이다  // String이냐?
			return true;																														// 비어있다
		}
		
		String str = (String)obj;	// 문장이더라도
		
		return str.trim().length() == 0;		// 좌우 공백을 제거하고 길이가 0이다
	}
	
	

}
