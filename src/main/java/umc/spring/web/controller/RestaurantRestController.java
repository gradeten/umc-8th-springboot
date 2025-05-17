package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Restaurant;
import umc.spring.dto.RestaurantRequestDTO;
import umc.spring.dto.RestaurantResponseDTO;
import umc.spring.service.TempService.RestaurantCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantRestController {
    private final RestaurantCommandService restaurantCommandService;

    @PostMapping("/")
    public ApiResponse<RestaurantResponseDTO.RestaurantJoinResultDTO> join(@RequestBody @Valid RestaurantRequestDTO.RestaurantJoinDto request){
        Restaurant restaurant = restaurantCommandService.joinRestaurant(request);
        return ApiResponse.onSuccess(RestaurantConverter.toJoinResultDTO(restaurant));
    }
}
