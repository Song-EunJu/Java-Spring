package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{

    // select m from Member m where m.name = ? 이런식으로 jpql 쿼리를 짜준다.
    // 메소드 이름을 보고 풀어낸ㄴ 것
    @Override
    Optional<Member> findByName(String name);
}
// spring data jpa가 JpaRepository 를 받고 있으면 스프링 빈에 자동으로 등록된다.