package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.MemberMission;
import umc.spring.dto.MemberMissionRequestDTO;
import umc.spring.dto.MemberMissionResponseDTO;
import umc.spring.service.TempService.MemberMissionCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member-missions")
public class MemberMissionRestController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/")
    public ApiResponse<MemberMissionResponseDTO.MemberMissionJoinResultDTO> join(
            @RequestBody @Valid MemberMissionRequestDTO.MemberMissionJoinDTO request) {

        MemberMission memberMission = memberMissionCommandService.joinMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toJoinResultDTO(memberMission));
    }
}
