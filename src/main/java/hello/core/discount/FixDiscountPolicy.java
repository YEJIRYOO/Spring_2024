package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount=1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {
        //enum 타입의 경우 "==" 이용하여 판별
        if(member.getGrade()== Grade.VIP){
            return discountFixAmount;
        }
        else return 0;
    }
}
