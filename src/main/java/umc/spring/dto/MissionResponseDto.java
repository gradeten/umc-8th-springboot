package umc.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import umc.spring.domain.Mission;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissionResponseDto {
    private Integer point;
    private String restaurantName;
    private Integer restaurantPrice;
    private LocalDate dueDate;  // 추가된 필드
    private String restaurantType;  // 추가된 필드

    public static MissionResponseDto from(Mission mission) {
        return new MissionResponseDto(
                mission.getPoint(),
                mission.getRestaurant().getName(),
                mission.getPrice(),
                mission.getDueDate(),
                mission.getRestaurant().getFoodCategory().getName() // 또는 getType().toString()
        );
    }
}

