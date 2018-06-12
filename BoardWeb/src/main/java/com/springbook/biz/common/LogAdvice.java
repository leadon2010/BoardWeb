package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {

	// 포인트컷 지정
	/*@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allpointcut() {
	}*/

	@Before("AllPointCut.allPointCut()")
	public void printLog() {
		System.out.println("[LogAdvice] 비즈니스 수행 전 동작");
	}

}
