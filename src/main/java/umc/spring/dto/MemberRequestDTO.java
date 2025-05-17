package umc.spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.validation.annotation.ExistCategories;

import java.time.LocalDate;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class MemberJoinDto{
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @NotNull
        LocalDate birthday;
        @Size(min = 3, max = 12)
        String address;
        @Size(min = 3, max = 12)
        String specAddress;
        @NotNull
        Boolean place_consent;
        @NotNull
        Boolean marketing_consent;
        @ExistCategories
        List<Long> preferCategory;
    }
}
