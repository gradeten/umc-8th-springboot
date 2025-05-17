package umc.spring.service.TempService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.dto.MissionsRequestDTO;
import umc.spring.dto.ReviewRequestDTO;

public interface MissionCommandService {
        @Transactional
        Mission joinMission(MissionsRequestDTO.@Valid MissionsJoinDTO request);

}
