package umc.spring.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistMission;
import umc.spring.validation.annotation.ExistRestaurant;
import umc.spring.validation.annotation.NotAlreadyJoined;

import java.time.LocalDate;

public class MemberMissionRequestDTO {
    @Getter
    @NotAlreadyJoined
    public static class MemberMissionJoinDTO{
        @NotNull
        @ExistMember
        Long member;
        @NotNull
        @ExistMission
        Long mission;
    }
}
