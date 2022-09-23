package com.example.demo;


import com.example.demo.member.MemoryMemberRepository;
import com.example.demo.order.OrderService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import java.io.File;

// @애노테이션은 상속관계 없음 -> 스프링 지원 기능으로 상속과 비슷하게 사용할 수 있음
// @ComponentScan : @Component 애노테이션이 붙은 클래스를 스캔해서 스프링 빈으로 등록
//@Configuration
//@ComponentScan(
//        basePackages = "com.example.demo.member",
//        basePackageClasses = AutoAppConfig.class,
//        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
//                classes = Configuration.class)
//)
// basePackages = "com.example.demo.member" : member만 @ComponentScan의 대상이 됨
@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = Configuration.class)
)
public class AutoAppConfig {


    // MemoryMemberRepository를 수동으로 빈 등록
    // 원래 자동으로 빈 등록이 되는데, 수동으로 같은 빈을 등록할 경우
    // 수동 등록한 빈이 우선순위를 가지고, 수동 빈이 자동 빈을 오버라이딩 함 -> 즉, 테스트 오류는 나지 않음
    // @SpringBootApplication 에노테이션 지정 후 실행하면 오류 남 -> 스프링부트에서 중복 허용 x
//    @Bean(name = "memoryMemberRepository")
//    MemoryMemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}