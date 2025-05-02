package umc.spring.repository.memberRepository;

import umc.spring.dto.MemberMyPageDto;

public interface MemberRepositoryCustom {
    MemberMyPageDto getMyPageInfo(Long memberId);
}
