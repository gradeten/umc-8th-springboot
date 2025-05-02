package umc.spring.domain.service.ReviewService;

public interface ReviewCommandService {
    void createReview(Long memberId, Long restaurantId, Float rating, String comment);
}
