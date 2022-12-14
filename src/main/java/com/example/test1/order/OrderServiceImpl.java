package com.example.test1.order;


import com.example.test1.discount.DiscountPolicy;
import com.example.test1.discount.FixDiscountPolicy;

import com.example.test1.member.Member;
import com.example.test1.member.MemberRepository;
import com.example.test1.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
        private final MemberRepository memberRepository = new MemoryMemberRepository();
        private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

        @Override public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }
}