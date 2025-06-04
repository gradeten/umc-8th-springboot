package umc.spring.domain.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import umc.spring.dto.MemberMyPageDto;
import umc.spring.dto.MemberResponseDTO;

public interface MemberQueryService {
    MemberMyPageDto getMyPage(Long memberId);
    MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request);
}

