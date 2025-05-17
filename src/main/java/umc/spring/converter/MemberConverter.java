package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.enums.Gender;
import umc.spring.dto.MemberRequestDTO;
import umc.spring.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.MemberJoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.MemberJoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.MemberJoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .birthday(request.getBirthday())
                .place_consent(request.getPlace_consent())
                .marketing_consent(request.getMarketing_consent())
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }
}