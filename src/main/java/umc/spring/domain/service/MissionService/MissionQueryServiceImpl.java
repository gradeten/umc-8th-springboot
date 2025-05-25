package umc.spring.domain.service.MissionService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.domain.service.MissionService.MissionQueryService;
import umc.spring.dto.MissionResponseDto;
import umc.spring.repository.missionRepository.MissionRepository;
import umc.spring.repository.restaurantRepository.RestaurantRepository;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public Page<MissionResponseDto> getMissionsByMemberAndStatus(Long memberId, String status, Pageable pageable) {
        return missionRepository.findMissionsByMemberIdAndStatus(memberId, status, pageable);
    }

    @Override
    public Page<MissionResponseDto> getMissionsByLocation(String address, Pageable pageable) {
        return missionRepository.findMissionsByLocation(address, pageable);
    }

    @Override
    public Page<Mission> getMissionListByStore(Long storeId, Integer page) {
        Restaurant restaurant = restaurantRepository.findById(storeId)
                .orElseThrow(() -> new EntityNotFoundException("해당 가게를 찾을 수 없습니다."));

        Pageable pageable = PageRequest.of(page, 10); // 한 페이지에 10개
        return missionRepository.findAllByRestaurant(restaurant, pageable);
    }
}
