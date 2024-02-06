package king.ide.controller;

import jakarta.validation.Valid;
import king.ide.controller.request.SignupRequest;
import king.ide.controller.response.SignupResponse;
import king.ide.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public SignupResponse signup(@RequestBody @Valid SignupRequest request) {
        log.info("signup controller 시작");
        long id = memberService.signup(request);
        return new SignupResponse(id, 200, "회원가입이 완료되었습니다.");
    }

    @GetMapping("/duplicate/{loginId}")
    public ResponseEntity<String> duplicatedLoginId(@PathVariable("loginId") String loginId) {
        memberService.validateDuplicatedLoginId(loginId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
