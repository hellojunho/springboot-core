package com.example.demo.discount;

import com.example.demo.member.Member;

public interface DiscountPolicy {
    
    // 빨간 글씨 나오면, f2 혹은 alt + enter --> 에러 솔루션 나옴

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
