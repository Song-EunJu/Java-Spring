package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원 저장
    Optional<Member> findById(Long id); // 해당 id를 찾았을 때 null인 경우 optional 로 감싸서 반환
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
