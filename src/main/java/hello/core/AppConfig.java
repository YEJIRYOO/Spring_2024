package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

/*
 AppConfig-> 애플리케이션의 전체 동작 방식 구성(config)위해,
 * 구현 객체 생성
 * 연결 (생성자를 통해 주입)
 의 책임 가지는 별도의 설정 클래스
 */

//애플리케이션의 실제 동작에 필요한 구현 객체 생성
public class AppConfig {

    public MemberService memberService(){
        //생성자 주입
        return new MemberServiceImpl(new MemoryMemberRepository());
        /*
        구현 클래스에서 생성자 설정 필요
         */
    }

    public OrderService orderService(){
        //구현체 반환
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new FixDiscountPolicy());
    }
}
