package umc.spring.domain.service.MemberMissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.MemberMission;

public interface MemberMissionQueryService {
    Page<MemberMission> getOngoingMissions(Long memberId, Integer page);
}
