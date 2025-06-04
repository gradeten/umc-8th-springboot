package umc.spring.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("spring.jwt.token")
@Getter
@Setter
public class JwtProperties {
    private String secretKey = "";
    private Expiration expiration = new Expiration(); // ⭐ null 방지

    @Getter
    @Setter
    public static class Expiration {
        private Long access = 3600000L; // ⭐ 기본값 지정 (1시간)
    }
}