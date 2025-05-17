package umc.spring.service.TempService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.foodRepository.FoodCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodCategoryService {

    private final FoodCategoryRepository foodCategoryRepository;

    public boolean existsAllById(List<Long> ids) {
        long count = foodCategoryRepository.countByIdIn(ids);
        return count == ids.size(); // 모두 존재해야 true
    }

    public boolean existsById(Long id) {
        return foodCategoryRepository.existsById(id);
    }
}