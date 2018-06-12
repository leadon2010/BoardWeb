package com.springbook.biz.common;

import org.aspectj.lang.annotation.Pointcut;

public class AllPointCut {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointCut() {
	}
}
