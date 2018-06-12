package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class Log4jAdvice {

	@Before("AllPointCut.allPointCut()")
	public void printLogging() {
		System.out.println("[Log4jAdvice 비즈니스 로직 수행 전 동작");
	}

}
