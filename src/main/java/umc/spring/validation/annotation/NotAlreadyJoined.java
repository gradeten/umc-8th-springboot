package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.NotAlreadyJoinedValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotAlreadyJoinedValidator.class)
@Target({ ElementType.TYPE }) // DTO 전체를 검증해야 하므로 TYPE에 적용
@Retention(RetentionPolicy.RUNTIME)
public @interface NotAlreadyJoined {
    String message() default "이미 해당 미션에 참여 중입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
