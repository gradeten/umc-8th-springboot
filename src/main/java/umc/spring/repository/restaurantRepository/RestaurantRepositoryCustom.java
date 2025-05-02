package umc.spring.repository.restaurantRepository;

import umc.spring.domain.Restaurant;

import java.util.List;

public interface RestaurantRepositoryCustom {
    List<Restaurant> dynamicQueryWithBooleanBuilder(String name, Float score);
}
