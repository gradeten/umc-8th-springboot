package umc.spring.converter;

import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.Restaurant;
import umc.spring.domain.enums.Gender;
import umc.spring.dto.MemberRequestDTO;
import umc.spring.dto.MemberResponseDTO;
import umc.spring.dto.RestaurantRequestDTO;
import umc.spring.dto.RestaurantResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class RestaurantConverter {
    public static RestaurantResponseDTO.RestaurantJoinResultDTO toJoinResultDTO(Restaurant restaurant){
        return RestaurantResponseDTO.RestaurantJoinResultDTO.builder()
                .restaurantId(restaurant.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Restaurant toRestaurant(RestaurantRequestDTO.RestaurantJoinDto request, FoodCategory foodCategory){

        return Restaurant.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .foodCategory(foodCategory)
                .name(request.getName())
                .build();
    }
}
