package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.service.MissionService.MissionQueryService;
import umc.spring.dto.MissionResponseDto;
import umc.spring.dto.MissionsRequestDTO;
import umc.spring.dto.MissionsResponseDTO;
import umc.spring.service.TempService.MissionCommandService;
import umc.spring.validation.annotation.ValidPage;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

    @PostMapping("/")
    public ApiResponse<MissionsResponseDTO.MissionsJoinResultDTO> join(@RequestBody @Valid MissionsRequestDTO.MissionsJoinDTO request) {
        Mission mission = missionCommandService.joinMission(request);
        return ApiResponse.onSuccess(MissionConverter.toJoinResultDTO(mission));
    }

    @GetMapping("/store")
    public ApiResponse<List<MissionResponseDto>> getMissionsByStore(
            @RequestParam Long storeId,
            @ValidPage Integer page) {

        Page<Mission> missions = missionQueryService.getMissionListByStore(storeId, page);

        List<MissionResponseDto> result = missions.stream()
                .map(MissionResponseDto::from)
                .collect(Collectors.toList());

        return ApiResponse.onSuccess(result);
    }
}
