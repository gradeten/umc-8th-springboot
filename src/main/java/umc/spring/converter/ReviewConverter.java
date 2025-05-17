package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.domain.enums.Gender;
import umc.spring.dto.MemberRequestDTO;
import umc.spring.dto.MemberResponseDTO;
import umc.spring.dto.ReviewRequestDTO;
import umc.spring.dto.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReviewConverter {

    public static ReviewResponseDTO.ReviewJoinResultDTO toJoinResultDTO(Review review){
        return ReviewResponseDTO.ReviewJoinResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.ReviewJoinDTO request){

        Member member = Member.builder().id(request.getMember()).build();
        Restaurant restaurant = Restaurant.builder().id(request.getRestaurant()).build();

        return Review.builder()
                .member(member)
                .restaurant(restaurant)
                .rating(request.getRating())
                .comment(request.getComment())
                .build();
    }
}
