package com.example.demo.member.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        // AnnotationConfigApplicationContext : 자바 애노테이션을 이용한 클래스로부터 객체 설정 정보를 가져온다
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // Thread A: A 사용자, 10000원
        int userAprice = statefulService1.order("userA", 10000);
        // Thread B : B 사용자, 20000원
        int userBprice = statefulService2.order("userB", 20000);
        
        // Thread A : A 사용자 주문 금액 조회
//        int price = statefulService1.getPrice();
        System.out.println("price = " + userAprice);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}