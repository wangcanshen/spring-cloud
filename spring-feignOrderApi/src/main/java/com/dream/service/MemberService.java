package com.dream.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dream.service.impl.MemberServiceFallback;
//
@FeignClient(value = "service-member",fallback=MemberServiceFallback.class)
public interface MemberService {
	
	@RequestMapping("/member/getProt")
	public String getMemberProt();
}
