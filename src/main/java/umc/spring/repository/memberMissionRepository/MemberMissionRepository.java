package umc.spring.repository.memberMissionRepository;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.MemberMission;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    boolean existsByMemberIdAndMissionId(@NotNull Long member, @NotNull Long mission);
    Page<MemberMission> findAllByMemberAndStatus(Member member, MissionStatus status, Pageable pageable);
}
