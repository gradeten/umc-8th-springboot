package umc.spring.service.TempService;

import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Restaurant;
import umc.spring.dto.RestaurantRequestDTO;

public interface RestaurantCommandService {
    @Transactional
    Restaurant joinRestaurant(RestaurantRequestDTO.@Valid RestaurantJoinDto request);
}
