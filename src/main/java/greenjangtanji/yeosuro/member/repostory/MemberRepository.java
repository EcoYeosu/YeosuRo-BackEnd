package greenjangtanji.yeosuro.member.repostory;

import greenjangtanji.yeosuro.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
