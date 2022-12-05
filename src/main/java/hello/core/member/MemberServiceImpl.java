package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //Bean은 자동 등록되지만, 의존 관계 주입은 할 방법이 없음. 따라서 생성자 위에 @Autowired 를 해주어야 함.
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    @Autowired //ac.getBean(MemberRepository.class) 와 같이 동작
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
