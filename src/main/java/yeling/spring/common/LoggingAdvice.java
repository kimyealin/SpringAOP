package yeling.spring.common;

public class LoggingAdvice {
	
	public void before() {
		System.out.println("[LA] 메서드 실행 전 전처리 수행");
	}
	public void afterReturning(Object ret) {
		System.out.println("[LA] 메서드 실행 후 후처리 수행, 리턴값=" + ret);
	}
	public void afterThrowing(Throwable ex) {
		System.out.println("[LA] 메서드 실행 중 예외 발생, 예외=" + ex.getClass().getName());
	}
	public void afterFinally() {
		System.out.println("[LA] 메서드 실행 완료");
	}
}
