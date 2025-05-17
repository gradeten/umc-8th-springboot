package umc.spring.service.TempService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import umc.spring.domain.Review;
import umc.spring.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    @Transactional
    Review joinReview(ReviewRequestDTO.@Valid ReviewJoinDTO request);


}
