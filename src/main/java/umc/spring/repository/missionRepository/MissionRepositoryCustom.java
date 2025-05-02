package umc.spring.repository.missionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.spring.dto.MissionResponseDto;

public interface MissionRepositoryCustom {
    Page<MissionResponseDto> findMissionsByMemberIdAndStatus(Long memberId, String status, Pageable pageable);
    Page<MissionResponseDto> findMissionsByLocation(String address, Pageable pageable);
}
