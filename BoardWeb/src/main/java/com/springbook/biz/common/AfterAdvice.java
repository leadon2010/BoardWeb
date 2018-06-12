package com.springbook.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {
	
	@After("AllPointCut.allPointCut()")
	public void finalLog() {
		System.out.println("[AfterAdvice] 비즈니스 로직 수행후 처리");
	}

}
