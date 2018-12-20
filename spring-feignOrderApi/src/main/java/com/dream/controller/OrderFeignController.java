package com.dream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dream.service.MemberService;

@RestController
@RequestMapping("order/feign")
public class OrderFeignController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("getMember")
	public String getMember() {
		System.out.println("进入feign调用接口");
		return memberService.getMemberProt();
	}
	
	@RequestMapping("getTest")
	public String getTest() {
		
		return "我进入接口了";
	}
}
