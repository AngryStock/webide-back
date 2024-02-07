package king.ide.service;

import java.util.Optional;
import king.ide.controller.request.LoginRequest;
import king.ide.controller.request.SignupRequest;
import king.ide.domain.Member;
import king.ide.exception.DuplicateException;
import king.ide.exception.UnauthorizedException;
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

    public void login(LoginRequest request) {
        Member findMember = memberRepository.findByLoginId(request.getLoginId()).orElse(null);
        if (findMember == null) {
            log.info("login service 아이디 존재 X");
            throw new UnauthorizedException("아이디 또는 비밀번호가 올바르지 않습니다.");
        }

        boolean isMatched = Member.matchPassword(passwordEncoder, request.getPassword(), findMember.getPassword());
        if (!isMatched) {
            log.info("login service 비밀번호 틀림");
            throw new UnauthorizedException("아이디 또는 비밀번호가 올바르지 않습니다.");
        }
    }
}
