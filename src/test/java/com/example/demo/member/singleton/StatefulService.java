package com.example.demo.member.singleton;

// 클래스명 선택 후, ctrl + shift + t : 해당 클래스의 테스트 클래스 자동 생성
public class StatefulService {

//    private int price;  // 상태를 유지하는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; // 여기가 문제!
        return price;
    }

//    public int getPrice() {
////        return price;
//    }
    
}
