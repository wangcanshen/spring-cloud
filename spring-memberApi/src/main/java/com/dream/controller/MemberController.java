package com.dream.controller;

import com.dream.aop.TokenAop;
import com.dream.param.MemberBean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("member")
public class MemberController {
	
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/getMember")
	public String getMember(String name) {
		System.out.println("进入会员接口了");
		System.out.println(name);
		
		return port;
	}
	
	@RequestMapping("/getProt")
	//@TokenAop(type = "HIDE")
	public String getProt() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("进入会员接口了"+port);
		return port;
	}
	
	@RequestMapping(value = "/getAop",method=RequestMethod.POST)
	//@TokenAop(type = "HIDE")
	public String getAop(@RequestBody MemberBean memberBean) {

		System.out.println("进入接口了获取到了token : "+memberBean.getToken());
		
		return port;
	}
	
}
