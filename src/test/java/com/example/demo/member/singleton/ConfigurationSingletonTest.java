package com.example.demo.member.singleton;

import com.example.demo.AppConfig;
import com.example.demo.member.MemberRepository;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberServiceImpl;
import com.example.demo.order.OrderService;
import com.example.demo.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> memberRepository = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);
        // 3개의 스프링 빈이 모두 같은 값으로 출력된다

        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep() {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
        // 출력내용
        // bean = class com.example.demo.AppConfig$$EnhancerBySpringCGLIB$$74fc38f6
        // EnhancerBySpringCGLIB : 스프링이 CGLIB 라이브러리를 사용해서 만든 임의의 클래스
        // 임의의 클래스를 스프링 빈으로 등록함 -> 싱글톤 보장되도록 해줌

        // 즉, 스프링 컨테이너에 이름은 appConfig이지만
        // 인스턴스 값은 AppConfig@CGLIB인 클래스가 등록됨
        // AppCongig@CGLIB : AppConfig의 자식 타입 -> AppConfig 타입으로 조회 가능
    }
}
