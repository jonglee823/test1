package com.example.test1.order;

import com.example.test1.member.Grade;
import com.example.test1.member.Member;
import com.example.test1.member.MemberService;
import com.example.test1.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl(); OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000); Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }

}