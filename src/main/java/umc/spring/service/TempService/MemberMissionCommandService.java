package umc.spring.service.TempService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import umc.spring.domain.MemberMission;
import umc.spring.domain.Mission;
import umc.spring.dto.MemberMissionRequestDTO;
import umc.spring.dto.MissionsRequestDTO;

public interface MemberMissionCommandService {
    @Transactional
    MemberMission joinMemberMission(MemberMissionRequestDTO.@Valid MemberMissionJoinDTO request);

    @Transactional
    void completeMission(Long memberMissionId);
}
