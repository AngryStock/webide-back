package king.ide.service;

import java.util.Optional;
import king.ide.controller.request.SignupRequest;
import king.ide.domain.Member;
import king.ide.exception.DuplicateException;
import king.ide.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public long signup(SignupRequest request) {
        log.info("signup service 시작");
        validateDuplicatedLoginId(request.getLoginId());
        log.info("signup service 아이디 중복 검사 완료");
        Member member = new Member();
        member.createMember(request, passwordEncoder);
        return memberRepository.save(member);
    }

    public void validateDuplicatedLoginId(String loginId) {
        Optional<Member> findMember = memberRepository.findByLoginId(loginId);
        if (findMember.isPresent()) {
            throw new DuplicateException("아이디가 중복되었습니다.");
        }
    }
}
