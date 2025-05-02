package umc.spring.repository.missionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.core.QueryResults;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;
import umc.spring.domain.*;
import umc.spring.domain.enums.MissionActive;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.dto.MissionResponseDto;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    QMission mission = QMission.mission;
    QRestaurant restaurant = QRestaurant.restaurant;
    QMemberMission memberMission = QMemberMission.memberMission;

    @Override
    public Page<MissionResponseDto> findMissionsByMemberIdAndStatus(Long memberId, String status, Pageable pageable) {
        JPAQuery<MissionResponseDto> query = queryFactory
                .select(Projections.fields(MissionResponseDto.class,
                        mission.point.as("point"),
                        restaurant.name.as("restaurantName"),
                        mission.price.as("restaurantPrice")
                ))
                .from(memberMission)
                .join(memberMission.mission, mission)
                .join(mission.restaurant, restaurant)
                .where(
                        memberMission.member.id.eq(memberId),
                        memberMission.status.eq(MissionStatus.valueOf(status))
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());

        QueryResults<MissionResponseDto> results = query.fetchResults();
        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }

    @Override
    public Page<MissionResponseDto> findMissionsByLocation(String address, Pageable pageable) {
        JPAQuery<MissionResponseDto> query = queryFactory
                .select(Projections.fields(MissionResponseDto.class,
                        mission.point.as("point"),
                        restaurant.name.as("restaurantName"),
                        mission.price.as("restaurantPrice"),
                        mission.dueDate.as("dueDate"),
                        restaurant.type.as("restaurantType")
                ))
                .from(mission)
                .join(mission.restaurant, restaurant)
                .where(
                        restaurant.address.eq(address),
                        mission.status.eq(MissionActive.valueOf("ACTIVE"))
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());

        QueryResults<MissionResponseDto> results = query.fetchResults();
        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }
}
