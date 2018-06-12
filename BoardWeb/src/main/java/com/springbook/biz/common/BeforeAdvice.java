package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {

	/*@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
	public void getpointcut() {
	}*/

	@Before("GetPointCut.getPointCut()")
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		String args1 = (args != null && args.length > 0 ? args[0].toString() : "");
		System.out.println("[BeforeAdvice] " + method + " 비즈니스 로직 수행전 처리 , 메서도: " + args1);
	}

}
