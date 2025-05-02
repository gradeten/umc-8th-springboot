package umc.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

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
}

