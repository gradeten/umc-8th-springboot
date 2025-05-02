package umc.spring.domain.service.RestaurantService;

import umc.spring.domain.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantQueryService {

    Optional<Restaurant> findStore(Long id);
    List<Restaurant> findStoresByNameAndScore(String name, Float score);
}