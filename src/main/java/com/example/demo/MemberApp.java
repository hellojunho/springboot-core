package com.example.demo;

import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberServiceImpl;
import org.springframework.aop.support.annotation.AnnotationMethodMatcher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        // AppConfig에서 memberService 호출하면 MemberServiceImpl이 들어옴

        // ApplicationContext를 '스프링 컨테이너' 라고 한다
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
        // AppConfig의 정보들 (@Bean 어노테이션이 붙은 메소드들)을 전부 스프링 빈에 등록하고 관리해줌
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }

}
