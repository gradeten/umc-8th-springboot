package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.dto.MemberMissionRequestDTO;
import umc.spring.repository.memberMissionRepository.MemberMissionRepository;
import umc.spring.validation.annotation.NotAlreadyJoined;

@Component
@RequiredArgsConstructor
public class NotAlreadyJoinedValidator implements ConstraintValidator<NotAlreadyJoined, MemberMissionRequestDTO.MemberMissionJoinDTO> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(MemberMissionRequestDTO.MemberMissionJoinDTO value, ConstraintValidatorContext context) {
        if (value == null) return true;
        if (value.getMember() == null || value.getMission() == null) return true;

        boolean exists = memberMissionRepository.existsByMemberIdAndMissionId(value.getMember(), value.getMission());

        if (exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.ALREADY_JOINED_MISSION.toString())
                    .addPropertyNode("member") // 또는 "mission"도 가능하지만 보통 "member" 추천
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
