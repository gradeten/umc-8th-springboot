package umc.spring.repository.memberRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QMember;
import umc.spring.dto.MemberMyPageDto;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public MemberMyPageDto getMyPageInfo(Long memberId) {
        QMember member = QMember.member;

        return queryFactory
                .select(Projections.constructor(MemberMyPageDto.class,
                        member.name,
                        member.email,
                        member.phone_number,
                        member.point
                ))
                .from(member)
                .where(member.id.eq(memberId))
                .fetchOne();
    }
}
