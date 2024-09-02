package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class MemberServiceTest {

    //인터페이스 타입의 변수에 구현 객체 생성
    //다형성
    MemberService memberService=new MemberServiceImpl();

    @Test
    void join(){
        //given
        Member member=new Member(1L,"memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember=memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
