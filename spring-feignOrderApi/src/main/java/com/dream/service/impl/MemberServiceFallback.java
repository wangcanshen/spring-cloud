package com.dream.service.impl;

import org.springframework.stereotype.Component;

import com.dream.service.MemberService;

@Component
public class MemberServiceFallback implements  MemberService{

	@Override
	public String getMemberProt() {
		
		return "服务器异常。。。。。";
	}

}
