package com.example.demo.order;

import com.example.demo.annotation.MainDiscountPolicy;
import com.example.demo.discount.DiscountPolicy;
import com.example.demo.member.Member;
import com.example.demo.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
// @RequiredArgsConstructor
// @RequiredArgsConstructor : final이 붙은 객체에 대한 생성자 자동 생성해주는 애노테이션
public class OrderServiceImpl implements OrderService {
    
    // 결론 : 의존관계 주입은 항상 생성자 주입을 사용하고, 옵션에 따라 수정자 주입도 사용한다
    // 하지만, 필드 주입 방식은 사용하지 않는 것이 좋다

//    // 필드 주입 방식 (권장하지 않음 / 코드는 간단하지만, 외부에서 변경 불가 : 테스트 어려움)
//    @Autowired private MemberRepository memberRepository;
//    @Autowired private DiscountPolicy discountPolicy;

    // final 지정을 하면, 생성자에서 this지정 누락을 방지할 수 있음
    // 생성자 주입을 사용하면 필드에 final 키워드를 사용할 수 있다
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;  // 추상화인 인터페이스에 의존
    // 철저하게 인터페이스에만 의존하고 있음 -> DIP 지키고 있음

    // 생성자 주입 : 스프링 빈 등록과 함께 의존관계 주입도 같이 일어난다
    // 생성자가 딱 1개만 있으면, @Autowired 애노테이션 생략 가능
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy  DiscountPolicy discountPolicy) {
//        // 테스트 용도의 출력문
//        // 스프링 빈 등록이 되었다면, 테스트시, 출력문이 null이 아니고 값이 출력될 것
//        System.out.println("memberRepository = " + memberRepository);
//        System.out.println("discountPolicy = " + discountPolicy);
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

//    // 수정자 자동 주입
//    public OrderServiceImpl(@MainDiscountPolicy  DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

    //    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
