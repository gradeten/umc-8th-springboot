package umc.spring.domain.service.RestaurantService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;

import java.util.List;
import java.util.Optional;

public interface RestaurantQueryService {

    Optional<Restaurant> findStore(Long id);
    List<Restaurant> findStoresByNameAndScore(String name, Float score);

    Page<Review> getReviewList(Long storeId, Integer page);
    Page<Review> getMyReviewList(Long memberId, Integer page);
}