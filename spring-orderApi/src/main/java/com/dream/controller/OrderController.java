package com.dream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dream.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {
	
	@Value("${server.port}")
	private String port;
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/getOrderMember")
	public String getOrderMember() {
		
		return orderService.getOrderMember();
	}
	
	@RequestMapping("/getProt")
	public String getProt(String name) {
		System.out.println("进入会员接口了"+port);
		return port;
	}
}
