package yeling.spring.board.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import yeling.spring.board.service.WriteArticleService;
import yeling.spring.board.vo.ArticleVO;
import yeling.spring.member.service.MemberService;
import yeling.spring.member.vo.MemberVO;

public class MainOne {

	public static void main(String[] args) {
		String[] configLocations = new String[] {"applicationContextOne.xml"};
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
		WriteArticleService articleService = (WriteArticleService)context.getBean("writeArticleService");
		articleService.write(new ArticleVO());
		MemberService memberService = context.getBean("memberService", MemberService.class);
		memberService.regist(new MemberVO());
		context.close();
	}

}
