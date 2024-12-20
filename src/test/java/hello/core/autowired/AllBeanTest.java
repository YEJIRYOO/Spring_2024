package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(AutoAppConfig.class,DiscountService.class);
        DiscountService discountService=ac.getBean(DiscountService.class);
        Member member=new Member(1L,"userA", Grade.VIP);
        int discountPrice=discountService.discount(member,10000,"fixDiscountPolicy");

        Assertions.assertThat(discountService).isInstanceOf(DiscountService.class);
        Assertions.assertThat(discountPrice).isEqualTo(1000);
    }

    static class DiscountService{

        private final Map<String, DiscountPolicy>policyMap;
        private final List<DiscountPolicy>policies;

        //하나의 생성자 -> @Autowired 생략 가능
        public DiscountService(Map<String,DiscountPolicy>policyMap,
                               List<DiscountPolicy>policies){
            this.policyMap=policyMap;
            this.policies=policies;
            System.out.println("policyMap = " + policyMap + ", \npolicies = " + policies);
        }

        public int discount(Member member,int price, String discountCode){
            DiscountPolicy discountPolicy=policyMap.get(discountCode);

            System.out.println("member = " + member + ", price = " + price + ", \ndiscountCode = " + discountCode);

            return discountPolicy.discount(member,price);
        }
    }
}
