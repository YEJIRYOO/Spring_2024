package hello.core.member;

public interface MemberRepository {

    //레포지토리에 멤버 저장
    void save(Member member);

    //레포지토리에서 멤버 검색
    Member findById(Long memberId);
}
