package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    //AppConfig에서 넣어줬기 때문에 여기에서는 인터페이스만 의존하게됨
    //생성자의 매개변수를 통해 AppConfig에서 구현체를 MemberServiceImpl에 전달함! => 생성자 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //MemberRepository의 구현체인 MemoryMemberRepository의 join 메소드가 호출이 됨
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
