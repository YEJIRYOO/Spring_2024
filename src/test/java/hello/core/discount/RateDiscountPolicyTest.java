package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy=new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o(){
        //given
        Member member=new Member(1L,"memberVIP", Grade.VIP);
        //when
        int discount= discountPolicy.discount(member,10000);
        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    /*
    단위 테스트 진행 시 실패 케이스도 확인해봐야한다!
     */
    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x(){
        //given
        Member member=new Member(2L,"memberBASIC",Grade.BASIC);
        //when
        int discount= discountPolicy.discount(member,10000);
        //then
        // Assertions.assertThat(discount).isEqualTo(1000);
        /*
        결과: Test failed
        Expected :1000
        Actual   :0
         */
        Assertions.assertThat(discount).isEqualTo(0);
    }

    //git 계정 테스트용
}