package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {

	@AfterThrowing(throwing = "exceptObj", pointcut = "AllPointCut.allPointCut()")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		String exceptStr = (exceptObj != null ? exceptObj.getMessage() : "Null");
		System.out.println("[AfterThrowing] " + method + " 비즈니스 로직 수행 중 에러 발생 " + exceptStr);
	}

}
