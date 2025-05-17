package umc.spring.service.TempService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.memberRepository.MemberRepository;
import umc.spring.repository.missionRepository.MissionRepository;

@Service
@RequiredArgsConstructor
public class MissionService {
    private final MissionRepository missionRepository;

    public boolean existsById(Long id) {
        return missionRepository.existsById(id);
    }
}
