package yeling.spring.board.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import yeling.spring.board.service.ReadArticleService;
import yeling.spring.board.vo.ArticleNotFoundException;
import yeling.spring.board.vo.ArticleVO;
import yeling.spring.member.service.MemberService;
import yeling.spring.member.vo.UpdateInfo;

public class MainFour {
	public static void main(String[] args) {
		String[] configLocations = new String[] { "applicationContextFour.xml" };
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
		ReadArticleService readArticleService = context.getBean("readArticleService", ReadArticleService.class);
		try {
			ArticleVO article1 = readArticleService.getArticleAndIncreaseReadCount(1);
			ArticleVO article2 = readArticleService.getArticleAndIncreaseReadCount(1);
			System.out.println("article1 == article2 : " + (article1 == article2));
			readArticleService.getArticleAndIncreaseReadCount(0);
		} catch (ArticleNotFoundException e) {
		}
		MemberService memberService = context.getBean("memberService", MemberService.class);
		memberService.update("기매링", new UpdateInfo());
		context.close();
	}
}
