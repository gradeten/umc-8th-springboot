package umc.spring.service.TempService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.MemberMission;
import umc.spring.domain.Mission;
import umc.spring.dto.MemberMissionRequestDTO;
import umc.spring.dto.MissionsRequestDTO;
import umc.spring.repository.memberMissionRepository.MemberMissionRepository;
import umc.spring.repository.missionRepository.MissionRepository;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public MemberMission joinMemberMission(MemberMissionRequestDTO.@Valid MemberMissionJoinDTO request) {
        MemberMission newMemberMission = MemberMissionConverter.toMemberMission(request);
        return memberMissionRepository.save(newMemberMission);
    }
}
