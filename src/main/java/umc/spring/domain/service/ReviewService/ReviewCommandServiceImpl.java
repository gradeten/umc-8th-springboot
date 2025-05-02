package umc.spring.domain.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.*;
import umc.spring.repository.memberRepository.MemberRepository;
import umc.spring.repository.restaurantRepository.RestaurantRepository;
import umc.spring.repository.reviewRepository.ReviewRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public void createReview(Long memberId, Long restaurantId, Float rating, String comment) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("회원 없음"));
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("가게 없음"));

        Review review = Review.builder()
                .member(member)
                .restaurant(restaurant)
                .rating(rating)
                .comment(comment)
                .build();

        reviewRepository.save(review);
    }
}
