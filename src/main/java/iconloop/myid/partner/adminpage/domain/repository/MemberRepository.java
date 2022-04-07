package iconloop.myid.partner.adminpage.domain.repository;

import iconloop.myid.partner.adminpage.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByMemberId(String memberId);
}
