package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//YeJiRyoo계정으로 커밋

/*
 AppConfig-> 애플리케이션의 전체 동작 방식 구성(config)위해,
 * 구현 객체 생성
 * 연결 (생성자를 통해 주입)
 의 책임 가지는 별도의 설정 클래스
 */


//애플리케이션의 실제 동작에 필요한 구현 객체 생성
@Configuration //설정 구성
public class AppConfig {

    /* 1.
    // BEFORE 리팩터링: 역할과 구분이 잘 드러나지 않는 상태, 코드 중복 존재

    public MemberService memberService(){
        //생성자 주입
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        //구현체 반환
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new FixDiscountPolicy());
    }
     */

    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    //-> 현재 나의 애플리케이션에서 MemberRepos 로는 MemorymemberRepos 를 사용하고,
    //   DiscountPolicy 로는 FixDiscountPolicy 를 사용함을 한 눈에 알 수 O
    //   향후 수정 시 생성 부분만 수정하면 됨

    //@Bean memberService -> new MemoryMemberRepository
    //@Bean orderService -> new MemoryMemberRepository
    //-> 다른 두 개의 객체 생성. 싱글톤 깨지나?
    @Bean
    public MemberService memberService(){
        //생성자 주입
        return new MemberServiceImpl(memberRepository());
    }

    @Bean //스프링 컨테이너에 스프링 빈으로 등록
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        //구현체 반환
        return new OrderServiceImpl();
    }

    //-> 현재 내 애플리케이션에서 사용하는 memberRepository 와 discountPolicy 를 사용할거야

}
