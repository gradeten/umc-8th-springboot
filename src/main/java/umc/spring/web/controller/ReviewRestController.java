package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.RestaurantConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.service.RestaurantService.RestaurantQueryService;
import umc.spring.dto.RestaurantResponseDTO;
import umc.spring.dto.ReviewRequestDTO;
import umc.spring.dto.ReviewResponseDTO;
import umc.spring.service.TempService.ReviewCommandService;
import umc.spring.validation.annotation.ValidPage;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;
    private final RestaurantQueryService restaurantQueryService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.ReviewJoinResultDTO> join(@RequestBody @Valid ReviewRequestDTO.ReviewJoinDTO request) {
        Review review = reviewCommandService.joinReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toJoinResultDTO(review));
    }

    @GetMapping("/my")
    public ApiResponse<RestaurantResponseDTO.ReviewPreViewListDTO> getMyReviewList(
            @RequestParam Long memberId,
            @ValidPage Integer page) {
        Page<Review> reviewPage = restaurantQueryService.getMyReviewList(memberId, page);
        return ApiResponse.onSuccess(RestaurantConverter.reviewPreViewListDTO(reviewPage));
    }
}
