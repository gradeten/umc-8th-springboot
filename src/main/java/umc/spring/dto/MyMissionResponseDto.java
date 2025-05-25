package umc.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import umc.spring.domain.MemberMission;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyMissionResponseDto {
    private Integer point;
    private String restaurantName;
    private Integer restaurantPrice;
    private LocalDate dueDate;
    private String restaurantType;

    public static MyMissionResponseDto from(MemberMission mm) {
        Mission mission = mm.getMission();
        Restaurant restaurant = mission.getRestaurant();

        return new MyMissionResponseDto(
                mission.getPoint(),
                restaurant.getName(),
                mission.getPrice(),
                mission.getDueDate(),
                restaurant.getFoodCategory().getName()
        );
    }
}
