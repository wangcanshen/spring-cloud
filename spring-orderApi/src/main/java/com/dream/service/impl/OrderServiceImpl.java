package com.dream.service.impl;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dream.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public String getOrderMember() {
		System.out.println("进入订单获取会员接口了");
		
		return restTemplate.getForObject("http://service-member/member/getMember", String.class);
		
	}

}
