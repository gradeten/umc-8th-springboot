package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.MemberMission;
import umc.spring.domain.service.MemberMissionService.MemberMissionQueryService;
import umc.spring.dto.MemberMissionRequestDTO;
import umc.spring.dto.MemberMissionResponseDTO;
import umc.spring.dto.MyMissionResponseDto;
import umc.spring.service.TempService.MemberMissionCommandService;
import umc.spring.validation.annotation.ValidPage;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member-missions")
public class MemberMissionRestController {

    private final MemberMissionCommandService memberMissionCommandService;
    private final MemberMissionQueryService memberMissionQueryService;

    @PostMapping("/")
    public ApiResponse<MemberMissionResponseDTO.MemberMissionJoinResultDTO> join(
            @RequestBody @Valid MemberMissionRequestDTO.MemberMissionJoinDTO request) {

        MemberMission memberMission = memberMissionCommandService.joinMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toJoinResultDTO(memberMission));
    }

    @GetMapping("/my/ongoing")
    public ApiResponse<List<MyMissionResponseDto>> getMyOngoingMissions(
            @RequestParam Long memberId,
            @ValidPage Integer page) {

        Page<MemberMission> missionPage = memberMissionQueryService.getOngoingMissions(memberId, page);

        List<MyMissionResponseDto> result = missionPage.stream()
                .map(MyMissionResponseDto::from)
                .collect(Collectors.toList());

        return ApiResponse.onSuccess(result);
    }

    @PatchMapping("/my/complete/{memberMissionId}")
    public ApiResponse<Void> completeMission(@PathVariable Long memberMissionId) {
        memberMissionCommandService.completeMission(memberMissionId);
        return ApiResponse.onSuccess(null);
    }
}
