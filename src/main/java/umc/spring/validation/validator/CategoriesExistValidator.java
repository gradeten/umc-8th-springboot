package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.foodRepository.FoodCategoryRepository;
import umc.spring.service.TempService.FoodCategoryService;
import umc.spring.validation.annotation.ExistCategories;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, Object> {

    private final FoodCategoryService foodCategoryService;

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) return true;

        if (value instanceof Long) {
            Long id = (Long) value;
            boolean exists = foodCategoryService.existsById(id);
            if (!exists) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(
                        ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()
                ).addConstraintViolation();
            }
            return exists;
        } else if (value instanceof List) {
            List<Long> ids = (List<Long>) value;
            if (ids.isEmpty()) return true;
            boolean exists = foodCategoryService.existsAllById(ids);
            if (!exists) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(
                        ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()
                ).addConstraintViolation();
            }
            return exists;
        }

        // 타입이 Long 또는 List<Long>이 아니면 검증 실패
        return false;
    }
}