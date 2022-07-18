package yeling.spring.common;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;

import yeling.spring.board.vo.ArticleVO;

@Aspect
public class ArticleCacheAspect implements Ordered {
	private Map<Integer, ArticleVO> cache = new HashMap<Integer, ArticleVO>();
	@Around("execution(public * *..ReadArticleService.*(..))")
	public ArticleVO cache(ProceedingJoinPoint joinPoint) throws Throwable{
		Integer id = (Integer)joinPoint.getArgs()[0];
		ArticleVO article = cache.get(id);
		if(article != null) {
			System.out.println("[ACA] 캐시에서 Article[" + id + "] 구함");
			return article;
		}
		ArticleVO ret = (ArticleVO)joinPoint.proceed();
		if(ret != null) {
			cache.put(id, ret);
			System.out.println("[ACA] 캐시에 Article[" + id + "] 추가함");
		}
		return ret;
	}
	@Override
	public int getOrder() {
		return 2;
	}

}
