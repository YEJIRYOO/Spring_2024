package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class OrderApp {

    //자바에서 클래스 내부의 코드는 반드시 메서드 내에 있어야함!!
    public static void main(String[] args) {
        AppConfig appConfig=new AppConfig();
        MemberService memberService=appConfig.memberService();
        OrderService orderService=appConfig.orderService();

        long memberId=1L;
        Member member=new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order=orderService.createOrder(memberId,"itemA",10000);

        System.out.println("order="+order);
    }

}
