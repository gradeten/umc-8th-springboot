package umc.spring.domain.service.MissionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.spring.domain.Mission;
import umc.spring.dto.MissionResponseDto;

public interface MissionQueryService {
    Page<MissionResponseDto> getMissionsByMemberAndStatus(Long memberId, String status, Pageable pageable);
    Page<MissionResponseDto> getMissionsByLocation(String address, Pageable pageable);
    Page<Mission> getMissionListByStore(Long storeId, Integer page);
}
