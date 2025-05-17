package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.MemberMission;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.dto.*;

import java.time.LocalDateTime;

public class MemberMissionConverter {

    public static MemberMissionResponseDTO.MemberMissionJoinResultDTO toJoinResultDTO(MemberMission memberMission){
        return MemberMissionResponseDTO.MemberMissionJoinResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toMemberMission(MemberMissionRequestDTO.MemberMissionJoinDTO request){

        Member member = Member.builder().id(request.getMember()).build();
        Mission mission = Mission.builder().id(request.getMission()).build();

        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();
    }
}
