package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.dto.MissionsRequestDTO;
import umc.spring.dto.MissionsResponseDTO;
import umc.spring.dto.ReviewRequestDTO;
import umc.spring.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionsResponseDTO.MissionsJoinResultDTO toJoinResultDTO(Mission mission){
        return MissionsResponseDTO.MissionsJoinResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionsRequestDTO.MissionsJoinDTO request){

        Restaurant restaurant = Restaurant.builder().id(request.getRestaurant()).build();

        return Mission.builder()
                .restaurant(restaurant)
                .price(request.getPrice())
                .point(request.getPoint())
                .dueDate(request.getDueDate())
                .build();
    }
}
