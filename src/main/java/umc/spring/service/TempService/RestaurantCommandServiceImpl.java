package umc.spring.service.TempService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Restaurant;
import umc.spring.dto.RestaurantRequestDTO;
import umc.spring.repository.foodRepository.FoodCategoryRepository;
import umc.spring.repository.restaurantRepository.RestaurantRepository;

@Service
@RequiredArgsConstructor
public class RestaurantCommandServiceImpl implements RestaurantCommandService {

    private final RestaurantRepository restaurantRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Transactional
    @Override
    public Restaurant joinRestaurant(RestaurantRequestDTO.@Valid RestaurantJoinDto request) {
        FoodCategory foodCategory = foodCategoryRepository.findById(request.getFoodCategoryId())
                .orElseThrow(() -> new RuntimeException("해당 카테고리가 없습니다!"));

        Restaurant newRestaurant = RestaurantConverter.toRestaurant(request, foodCategory);
        return restaurantRepository.save(newRestaurant);
    }
}
