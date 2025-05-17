package umc.spring.service.TempService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.restaurantRepository.RestaurantRepository;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public boolean existsById(Long id) {
        return restaurantRepository.existsById(id);
    }
}
