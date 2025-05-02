package umc.spring.domain.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.dto.MemberMyPageDto;
import umc.spring.repository.memberRepository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;

    @Override
    public MemberMyPageDto getMyPage(Long memberId) {
        return memberRepository.getMyPageInfo(memberId);
    }
}
