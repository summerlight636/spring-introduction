package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
    //리팩토링 후:
    //1. 메서드 명 보는 순간 역할과 구현 클래스가 다 드러남. 즉 설계했던 그림이 구성 정보에 그대로 반영되었다.
    //AppConfig를 보면 역할과 구현 클래스가 한눈에 들어온다. 애플리케이션 전체 구성이 어떻게 되어있는지 빠르게 파악할 수 있다.
    //ex) 현재 애플리케이션에서 MemberRepository(역할)는 MemoryMemberRepository(구현)를 쓸거야.
    //중복을 제거 했기 때문에, 다른 구현체로 변경할 때 한 부분만 변경하면 됨!

}
