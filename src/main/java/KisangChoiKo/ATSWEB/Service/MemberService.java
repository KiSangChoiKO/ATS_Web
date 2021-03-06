package KisangChoiKo.ATSWEB.Service;

import KisangChoiKo.ATSWEB.Domain.Member;
import KisangChoiKo.ATSWEB.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public String join(Member member) throws Exception{
        memberRepository.insertMember(member);
        return member.getId();
    }

    public int UniqueName(Member member) throws Exception{
        Optional<Member> result = memberRepository.getDetailMember(member.getId());
        if(result.isPresent())
            return 1;
        else return 0;
    }
    public Optional<Member> findMember(String id) throws Exception{
        return memberRepository.getDetailMember(id);
    }
}
