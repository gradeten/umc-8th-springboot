package umc.spring.repository.reviewRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // 추가적인 메소드가 필요하면 여기에 정의할 수 있습니다.
}
