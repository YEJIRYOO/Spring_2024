package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    //AppConfig 이전
//    private final MemberRepository memberRepository=new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy=new FixDiscountPolicy();
////    private final DiscountPolicy discountPolicy=new RateDiscountPolicy();
//    /*
//    OCP, DIP 문제 발생 : OrderService가 인터페이스 뿐만 아니라 구현에도 의존!
//    -> 기능 확장하여 변경 시, 클라이언트 코드에 영향을 미침
//     */

    //AppConfig 이후
    //구현체가 아닌 인터페이스에 의존
    //실행에만 집중
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository,DiscountPolicy discountPolicy){
        this.memberRepository=memberRepository;
        this.discountPolicy=discountPolicy;
    }
    @Override
    public Order createOrder(Long memberId,String itemName,int itemPrice){

        Member member=memberRepository.findById(memberId);
        int discountPrice= discountPolicy.discount(member,itemPrice);
        //SRP 준수!

        return new Order(memberId,itemName,itemPrice,discountPrice);
        //주문 객체 생성하여 반환
    }
}
