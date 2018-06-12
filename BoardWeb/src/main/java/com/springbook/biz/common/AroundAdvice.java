package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		StopWatch stopWtch = new StopWatch();
		stopWtch.start();

		System.out.println("[BEFORE] around 로직 수행 전");
		// 서비스 메서드 호출
		Object returnObj = pjp.proceed();
		stopWtch.stop();
		System.out.println(method + "() 메소드 수행에 걸린 시간: " + stopWtch.getTotalTimeMillis() + "(ms)초");
		System.out.println("[AFTER] around 로직 수행 후");

		return returnObj;

	}

}
