package KisangChoiKo.ATSWEB.repository;

import KisangChoiKo.ATSWEB.Domain.Member;
import java.util.Optional;

public interface MemberRepository {
    String insertMember(Member member) throws Exception;
    Optional<Member> getDetailMember(String id) throws Exception;
}
