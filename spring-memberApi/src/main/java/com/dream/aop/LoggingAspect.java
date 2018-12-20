package com.dream.aop;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dream.param.MemberBean;

@Component
@Aspect
public class LoggingAspect {

	@Pointcut("execution(public * com.dream.controller.*.*(..))")
	public void rlAop() {
	}

//	@Before("rlAop()")
//	public Object before(JoinPoint jp) {
//		Object [] s = jp.getArgs();
//		for (Object object : s) {
//			System.out.println("----------"+object);
//		}
//		System.out.println("++++++++++"+getRequest().getParameter("token"));
//		System.out.println("++++++++++"+getRequest().getParameter("name"));
//		System.out.println("进入方法前");
//		Map<String, String> params = new HashMap<>();
//		Map<String, String[]> requestParams = getRequest().getParameterMap();
//		 for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
//	            String name = (String) iter.next();
//	            String[] values = (String[]) requestParams.get(name);
//	            String valueStr = "";
//	            for (int i = 0; i < values.length; i++) {
//	                valueStr = (i == values.length - 1) ? valueStr + values[i]
//	                        : valueStr + values[i] + ",";
//	            }
//	            //乱码解决，这段代码在出现乱码时使用。
//	            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
//	            System.out.println(name);
//	            params.put(name, valueStr);
//	        }
//		return null;
//	}
//	 /**
//     * 后置通知：目标方法执行之后执行以下方法体的内容，不管是否发生异常。
//     * @param jp
//     */
//	@After("rlAop()")
//	public Object after(JoinPoint jp) {
//
//		return null;
//	}
	/**
     * 返回通知：目标方法正常执行完毕时执行以下代码
     * @param jp
     * @param result
     */
    @Around("rlAop()")
    public Object afterReturningMethod(ProceedingJoinPoint jp){
    	Object [] s = jp.getArgs();
		for (Object object : s) {
			MemberBean memberBean = (MemberBean)object;
			System.out.println(memberBean.getToken());
			System.out.println("----------"+object);
		}
		JSONObject jsonObject = (JSONObject)getRequest().getAttribute("__jsonObject");
        if (jsonObject == null) {
            InputStream reader;
			try {
				reader = getRequest().getInputStream();
				String _signKey = IOUtils.toString(reader, "utf-8");
				jsonObject = JSON.parseObject(_signKey);
				reader.close();
				//System.out.println("token : "+jsonObject.getString("token"));
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        Object proceed = null;
        try {
        	proceed = jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return proceed;
	}
//    /**
//     * 异常通知：目标方法发生异常的时候执行以下代码
//     */
//    @AfterThrowing(value="rlAop()",throwing="e")
//    public void afterThorwingMethod(JoinPoint jp, NullPointerException e){
//        String methodName = jp.getSignature().getName();
//        System.out.println("【异常通知】the method 【" + methodName + "】 occurs exception: " + e);
//    }
//
	public HttpServletRequest getRequest() {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		return request;
	}
}
