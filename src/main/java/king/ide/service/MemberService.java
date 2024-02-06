package king.ide.service;

import king.ide.controller.request.SignupRequest;
import king.ide.domain.Member;
import king.ide.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public long signup(SignupRequest request) {
        Member member = new Member();
        member.createMember(request, passwordEncoder);
        return memberRepository.save(member);
    }
}
