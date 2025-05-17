package umc.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.spring.domain.service.MemberService.MemberQueryService;
import umc.spring.domain.service.MissionService.MissionQueryService;
import umc.spring.domain.service.RestaurantService.RestaurantQueryService;
import umc.spring.dto.MemberMyPageDto;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			// 서비스 호출
//			MissionQueryService missionService = context.getBean(MissionQueryService.class);
//			ReviewCommandService reviewService = context.getBean(ReviewCommandService.class);
//			MemberQueryService memberService = context.getBean(MemberQueryService.class);
//
//			System.out.println("📍 내가 진행중인 미션:");
//			missionService.getMissionsByMemberAndStatus(1L, "ONGOING", PageRequest.of(0, 3)).forEach(System.out::println);
//
//			System.out.println("📍 내가 완료한 미션:");
//			missionService.getMissionsByMemberAndStatus(1L, "DONE", PageRequest.of(0, 3)).forEach(System.out::println);
//
//			System.out.println("📍 리뷰 작성:");
//			reviewService.createReview(1L, 1L, 4.0f, "맛있었어요!");
//
//			System.out.println("📍 홈화면 미션:");
//			missionService.getMissionsByLocation("경기도", PageRequest.of(0, 3)).forEach(System.out::println);
//
//			System.out.println("📍 마이페이지 정보:");
//			MemberMyPageDto myPageInfo = memberService.getMyPage(1L);
//			System.out.println(myPageInfo);

		};
	}
}

