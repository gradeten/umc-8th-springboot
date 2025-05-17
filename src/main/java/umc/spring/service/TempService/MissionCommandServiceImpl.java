package umc.spring.service.TempService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.dto.MissionsRequestDTO;
import umc.spring.repository.missionRepository.MissionRepository;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;

    @Transactional
    @Override
    public Mission joinMission(MissionsRequestDTO.@Valid MissionsJoinDTO request) {

        Mission newMission = MissionConverter.toMission(request);
        return missionRepository.save(newMission);
    }
}
