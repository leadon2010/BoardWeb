package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterReturningAdvice {

	@AfterReturning(returning = "returnObj", pointcut = "AllPointCut.allPointCut()")
	public void afterLog(JoinPoint jp, Object returnObj) {
		// 메서드 명 읽어내기
		String method = jp.getSignature().getName();
		String returnStr = (returnObj != null ? returnObj.toString() : "Null");
		System.out.println("[AfterReturningAdvice] " + method + " 비즈니스 로직 정상 수행 후 처리 return: " + returnStr);
	}

}
