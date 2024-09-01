package hello.core.member;

/*
구현체 하나만 있을 때 Impl로 작성
 but 확장시에 문제 발생 가능할듯
 */
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository=new MemoryMemberRepository();
    //구현체 명시 x -> null 포인트 exception 발생
    /*
     * 문제 상황: 인터페이스(추상화)와 구현체(구체화) 동시에 의존
     * -> OCP, DIP 위배
     */
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
