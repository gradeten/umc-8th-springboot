package umc.spring.domain.service.RestaurantService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.repository.memberRepository.MemberRepository;
import umc.spring.repository.restaurantRepository.RestaurantRepository;
import umc.spring.repository.reviewRepository.ReviewRepository;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantQueryServiceImpl implements RestaurantQueryService {

    private final RestaurantRepository restaurantRepository;
    private final MemberRepository memberRepository;

    private final ReviewRepository reviewRepository;
    private Long storeId;
    private Integer page;

    @Override
    public Optional<Restaurant> findStore(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public List<Restaurant> findStoresByNameAndScore(String name, Float score) {
        List<Restaurant> filteredStores = restaurantRepository.dynamicQueryWithBooleanBuilder(name, score);

        filteredStores.forEach(store -> System.out.println("Store: " + store));

        return filteredStores;
    }


    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {
        Restaurant restaurant = restaurantRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Restaurant not found"));
        return reviewRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));
    }


    @Override
    public Page<Review> getMyReviewList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("Member not found"));

        if (page < 0) page = 0;  // 음수면 0으로 보정

        Pageable pageable = PageRequest.of(page, 10);  // 페이지 번호, 한 페이지 크기 10
        return reviewRepository.findAllByMember(member, pageable);
    }


}