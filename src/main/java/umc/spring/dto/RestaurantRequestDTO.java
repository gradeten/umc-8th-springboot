package umc.spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.domain.FoodCategory;
import umc.spring.validation.annotation.ExistCategories;

import java.time.LocalDate;
import java.util.List;

public class RestaurantRequestDTO {
    @Getter
    public static class RestaurantJoinDto{
        @NotBlank
        String name;
        @Size(min = 3, max = 12)
        String address;
        @Size(min = 3, max = 12)
        String specAddress;
        @ExistCategories
        Long foodCategoryId;
    }
}
