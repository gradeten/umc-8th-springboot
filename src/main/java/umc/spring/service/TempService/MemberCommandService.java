package umc.spring.service.TempService;

import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.dto.MemberRequestDTO;

public interface MemberCommandService {

    @Transactional
    Member joinMember(MemberRequestDTO.@Valid MemberJoinDto request);
}
