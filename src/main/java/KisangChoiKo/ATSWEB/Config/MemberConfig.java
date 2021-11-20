package KisangChoiKo.ATSWEB.Config;

import KisangChoiKo.ATSWEB.repository.MemberRepository;
import KisangChoiKo.ATSWEB.repository.MemoryMemberRepository;
import KisangChoiKo.ATSWEB.Service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class MemberConfig {

    DataSource dataSource;
    EntityManager em;


    public MemberConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository(em);
    }
}
