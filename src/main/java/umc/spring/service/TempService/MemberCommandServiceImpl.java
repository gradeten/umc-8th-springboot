package umc.spring.service.TempService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MemberPreferConverter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.MemberPrefer;
import umc.spring.dto.MemberRequestDTO;
import umc.spring.repository.foodRepository.FoodCategoryRepository;
import umc.spring.repository.memberRepository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Transactional
    @Override
    public Member joinMember(MemberRequestDTO.@Valid MemberJoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList =
                foodCategoryRepository.findAllById(request.getPreferCategory());

        List<MemberPrefer> memberPreferList =
                MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}