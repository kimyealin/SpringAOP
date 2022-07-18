package yeling.spring.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class LoggingAspect {
	@Before("PublicPointcut.publicMethod()")
	public void before() {
		System.out.println("[LA] 메서드 실행 전 전처리 수행");
	}
	
	@AfterReturning(pointcut = "yeling.spring.common.PublicPointcut.publicMethod()", returning = "ret")
	public void afterReturning(Object ret) {
		System.out.println("[LA] 메서드 실행 후 후처리 수행, 리턴값=" + ret);
	}

	@AfterThrowing(pointcut = "yeling.spring.common.PublicPointcut.publicMethod()", throwing = "ex")
	public void afterThrowing(Throwable ex) {
		System.out.println("[LA] 메서드 실행 중 예외 발생, 예외=" + ex.getClass().getName());
	}
	
	@After("yeling.spring.common.PublicPointcut.publicMethod()")
	public void afterFinally() {
		System.out.println("[LA] 메서드 실행 완료");
	}
}
