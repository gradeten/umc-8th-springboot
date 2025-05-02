package umc.spring.repository.memberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Member;
import umc.spring.dto.MemberMyPageDto;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
    // 추가적인 메소드가 필요하면 여기에 정의할 수 있습니다.
}
