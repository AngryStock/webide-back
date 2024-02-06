package king.ide.controller;

import jakarta.validation.Valid;
import king.ide.controller.request.SignupRequest;
import king.ide.controller.response.SignupResponse;
import king.ide.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public SignupResponse signup(@RequestBody @Valid SignupRequest request) {
        long id = memberService.signup(request);
        return new SignupResponse(id, 200, "회원가입이 완료되었습니다.");
    }
}
