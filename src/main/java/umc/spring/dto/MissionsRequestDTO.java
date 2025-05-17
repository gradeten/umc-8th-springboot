package umc.spring.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import umc.spring.validation.annotation.ExistCategories;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistRestaurant;

import java.time.LocalDate;
import java.util.List;

public class MissionsRequestDTO {
    @Getter
    public static class MissionsJoinDTO{
        @NotNull
        @ExistRestaurant
        Long restaurant;
        @NotNull
        Integer price;
        @NotNull
        Integer point;
        @NotNull
        @Future(message = "날짜는 현재보다 이후여야 합니다.")
        LocalDate dueDate;
    }
}

