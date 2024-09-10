package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    //자바에서 클래스 내부의 코드는 반드시 메서드 내에 있어야함!!
    public static void main(String[] args) {

        /*
        //상황1: 순수 자바 코드 -> AppConfig
        AppConfig appConfig=new AppConfig();
        MemberService memberService=appConfig.memberService();
        OrderService orderService=appConfig.orderService();
         */

        //상황2 :스프링 컨테이너 이용
        //스프링 컨테이너-> 모든 객체 관리
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService=
                applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService=
                applicationContext.getBean("orderService", OrderService.class);

        long memberId=1L;
        Member member=new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order=orderService.createOrder(memberId,"itemA",10000);

        System.out.println("order="+order);
    }

}
