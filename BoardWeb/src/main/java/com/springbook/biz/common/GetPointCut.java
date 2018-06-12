package com.springbook.biz.common;

import org.aspectj.lang.annotation.Pointcut;

public class GetPointCut {
	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
	public void getPointCut() {
	}
}
