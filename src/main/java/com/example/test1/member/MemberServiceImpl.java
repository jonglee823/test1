package com.example.test1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    //현재 memberRepository가 추상화, 구체화에 모두 의존 DIP 위반 --> 추후 변경 시 변경해야할 부분이 많음
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final MemberRepository memberRepository = new DBMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}