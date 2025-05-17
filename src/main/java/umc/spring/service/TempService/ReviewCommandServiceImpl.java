package umc.spring.service.TempService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.dto.ReviewRequestDTO;
import umc.spring.repository.reviewRepository.ReviewRepository;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;

    @Transactional
    @Override
    public Review joinReview(ReviewRequestDTO.@Valid ReviewJoinDTO request) {

        Review newReview = ReviewConverter.toReview(request);
        return reviewRepository.save(newReview);
    }
}
