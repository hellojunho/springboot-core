package com.example.demo.member.singleton;

public class SingletonService {

    ////////////
    private static final SingletonService instance = new SingletonService();
    // private static final : 초기화한 값을 끝까지 유지하기 위해 사용(값 불변)
    // private final : 직접 값을 참조는 할 수 없지만, 생성자를 통해 값을 참조할 수 있음
    // private static final : 생성자를 통해서도 값을 참조할 수 없다(선언 시, 반드시 초기화)
    public static SingletonService getInstance() {
        return instance;
    }
    // priave 생성자
    private SingletonService() {
    }
    ////////////

    // 싱글톤 패턴 문제점
    // 1. 아래 코드를 작성하려면 위에 //로 묶은 코드를 반드시 넣어야 한다. (코드가 많음)
    // 2. DIP 위반 : 클라이언트가 구체 클래스에 의존
    // 3. 2번 때문에 OCP위반 가능성 높음
    // 4. 유연한 테스트 어려움
    // 5. private 생성자로 자식 클래스를 만들기 어려움 등..
    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

    public static void main(String[] args) {
        SingletonService singletonService1 = new SingletonService();
        SingletonService singletonService2 = new SingletonService();

        System.out.println(singletonService1);
        System.out.println(singletonService2);
    }
}
