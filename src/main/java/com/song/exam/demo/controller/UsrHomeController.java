package com.song.exam.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsrHomeController {
	//private int count = 0; 여기서 초기화 하는 것보 생성자에서 초기화 하는 것이 좋다
	private int count;
	
	public UsrHomeController() {
		count = -1;
	}
	
	@RequestMapping("/usr/home/getCount")
	@ResponseBody
	public int getCount() {
		return count++;
	}
	
	@RequestMapping("/usr/home/dosetCount")
	@ResponseBody
	public String dosetCount(int count) {
		this.count = count;
		return "count 값이 " + this.count + " 로 초기화 되었습니다.";
	}


}
