package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);


//		// 등록된 스프링 빈 목록 출력하는 코드
//		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//
//		// 등록된 bean의 이름을 get
//		String[] beanNames = applicationContext.getBeanDefinitionNames();
//
//		// bean 이름을 출력
//		int i=1;
//		for(String beanName : beanNames) {
//			System.out.println(i + " : " + beanName);
//			i++;
//		}
		
		// 2022-08-25 출력 결과
//
//		1 : org.springframework.context.annotation.internalConfigurationAnnotationProcessor
//		2 : org.springframework.context.annotation.internalAutowiredAnnotationProcessor
//		3 : org.springframework.context.annotation.internalCommonAnnotationProcessor
//		4 : org.springframework.context.event.internalEventListenerProcessor
//		5 : org.springframework.context.event.internalEventListenerFactory
//		6 : appConfig
//		7 : memberService
//		8 : memberRepository
//		9 : orderService
//		10 : discountPolicy
	}
}
