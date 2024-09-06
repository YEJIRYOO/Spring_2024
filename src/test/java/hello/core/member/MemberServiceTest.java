package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MemberServiceTest {

    //인터페이스 타입의 변수에 구현 객체 생성
    //다형성
    MemberService memberService;

    /*변경사항*/
    //AppConfig을 통한 생성
    @BeforeEach //각 테스트 전에 무조건 실행
    public void beforeEach(){
        AppConfig appConfig=new AppConfig();
        memberService=appConfig.memberService();
    }
    /* ***************************************** */

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
