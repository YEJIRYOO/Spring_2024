package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

//애플리케이션의 실제 동작에 필요한 구현 객체 생성
public class AppConfig {

    public MemberService memberService(){
        //구현체 반환
        return new MemberServiceImpl(new MemoryMemberRepository());
        /*

         */
    }

    public OrderService orderService(){
        //구현체 반환
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new FixDiscountPolicy());
    }
}
