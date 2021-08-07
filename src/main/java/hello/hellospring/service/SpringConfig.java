package hello.hellospring.service;

import hello.hellospring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

//    private EntityManager em;
//
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    private final MemberRepository memberRepository;

    // spring data jpa 가 구현체를 만들어 놓은 것이 등록된다.
    // spring container 에서 memberRepository 를 찾는다.
    // springdatajpamemberrepository 의 인터페이스만 만들어놓으면 jpa repository 를 상속받아놓으면
    // 스프링 데이터 jpa가 인터페이스에 대한 구현체를 만들어낸다. 그리고 스프링빈에 등록한다.
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
//        return new MemberService(memberRepository());
        return new MemberService(memberRepository);

    }

//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }

}

