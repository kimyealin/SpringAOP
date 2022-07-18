package yeling.spring.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import yeling.spring.member.vo.UpdateInfo;

@Aspect
@Order(3)
public class UpdateMemberInfoTraceAspect {
	@AfterReturning(pointcut = "args(memberId,info)", returning = "result", argNames = "result,memberId,info")
	public void traceReturn(JoinPoint joinPoint, boolean result, String memberId, UpdateInfo info) {
		System.out.println("[TA] 정보 수정: 결과=" + result + ",대상회원=" + memberId + ",수정정보=" + info);
	}
}
