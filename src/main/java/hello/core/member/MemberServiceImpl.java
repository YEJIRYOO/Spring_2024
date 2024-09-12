package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
구현체 하나만 있을 때 Impl로 작성
 but 확장시에 문제 발생 가능할듯
 */
@Component
public class MemberServiceImpl implements MemberService{

    //AppConfig 이전
//    private final MemberRepository memberRepository=new MemoryMemberRepository();
//    //구현체 명시 x -> null 포인트 exception 발생
//    /*
//     * 문제 상황: 인터페이스(추상화)와 구현체(구체화) 동시에 의존
//     * -> OCP, DIP 위배
//     */
//
    //AppConfig 이후 : MemberRepository 생성 권한 없앰
    /*
     * MemberRepository 에만 의존
     * 어떤 구현 객체가 주입 될 지 MemberServiceImpl은 알 수 x
     * Dip 완성
     * 관심사의 분리
     */
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
