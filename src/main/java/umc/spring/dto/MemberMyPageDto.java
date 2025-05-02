package umc.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberMyPageDto {
    private String name;
    private String email;
    private String phone_number;
    private Integer point;
}
