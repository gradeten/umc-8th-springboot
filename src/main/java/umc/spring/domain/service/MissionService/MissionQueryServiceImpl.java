package umc.spring.domain.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.service.MissionService.MissionQueryService;
import umc.spring.dto.MissionResponseDto;
import umc.spring.repository.missionRepository.MissionRepository;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;


    @Override
    public Page<MissionResponseDto> getMissionsByMemberAndStatus(Long memberId, String status, Pageable pageable) {
        return missionRepository.findMissionsByMemberIdAndStatus(memberId, status, pageable);
    }

    @Override
    public Page<MissionResponseDto> getMissionsByLocation(String address, Pageable pageable) {
        return missionRepository.findMissionsByLocation(address, pageable);
    }
}
