package umc.spring.domain.service.MemberService;

import umc.spring.dto.MemberMyPageDto;

public interface MemberQueryService {
    MemberMyPageDto getMyPage(Long memberId);
}

