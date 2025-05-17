package umc.spring.repository.memberMissionRepository;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.MemberMission;
import umc.spring.domain.Mission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    boolean existsByMemberIdAndMissionId(@NotNull Long member, @NotNull Long mission);
}
