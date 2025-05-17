package umc.spring.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import umc.spring.validation.annotation.ExistCategories;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistRestaurant;

import java.time.LocalDate;
import java.util.List;

public class ReviewRequestDTO {
    @Getter
    public static class ReviewJoinDTO{
        @NotNull
        @ExistMember
        Long member;
        @NotNull
        @ExistRestaurant
        Long restaurant;
        @NotNull
        @DecimalMin("0.0")
        @DecimalMax("5.0")
        Float rating;
        @NotBlank
        String comment;
    }
}
