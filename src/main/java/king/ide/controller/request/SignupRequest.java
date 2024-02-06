package king.ide.controller.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SignupRequest {
    @NotEmpty(message = "이름을 입력해 주세요.")
    @Pattern(regexp = "^[a-zA-Z가-힣\\\\s]+$", message = "이름은 문자만 입력할 수 있습니다.")
    private String name;

    @NotEmpty(message = "아이디를 입력해 주세요.")
    private String loginId;

    @NotEmpty(message = "비밀번호를 입력해 주세요.")
    private String password;

    @NotEmpty(message = "휴대폰번호를 입력해 주세요.")
    private String mobileNumber;
}
