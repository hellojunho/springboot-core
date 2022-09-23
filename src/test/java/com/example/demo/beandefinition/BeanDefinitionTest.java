package com.example.demo.beandefinition;

import com.example.demo.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {

    // 스프링 빈 등록 방법 2가지
    // 1. 자바 코드로 등록 : 팩토리 메서드(AppConfig)를 통해 등록하는 방법
    // 2. xml로 등록하는 방법
    
    AnnotationConfigApplicationContext ac =
            new AnnotationConfigApplicationContext(AppConfig.class);

//    GenericXmlApplicationContext ac =
//            new GenericXmlApplicationContext("appConfig.xml");



    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " + beanDefinitionName +
                        " beanDefinition = " + beanDefinition);
            }
        }
    }
}