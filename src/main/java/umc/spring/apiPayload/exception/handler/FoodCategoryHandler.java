package umc.spring.apiPayload.exception.handler;

import lombok.Getter;
import umc.spring.apiPayload.code.status.ErrorStatus;

@Getter
public class FoodCategoryHandler extends RuntimeException{
    private final ErrorStatus errorStatus;

    public FoodCategoryHandler(ErrorStatus errorStatus) {
        super(errorStatus.getMessage());  // ErrorStatus가 메시지를 가진 enum이라고 가정
        this.errorStatus = errorStatus;
    }

}
