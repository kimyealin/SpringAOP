package yeling.spring.common;

import org.aspectj.lang.annotation.Pointcut;

public class PublicPointcut {
	@Pointcut("execution(public * yeling.spring..*(..))")
	public void publicMethod() {
		
	}
}
