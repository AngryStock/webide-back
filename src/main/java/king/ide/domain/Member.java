package king.ide.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import king.ide.controller.request.SignupRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;

@Entity
@Getter @Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String loginId;
    private String password;
    private String mobileNumber;

    public void createMember(SignupRequest request, PasswordEncoder passwordEncoder) {
        this.name = request.getName();
        this.loginId = request.getLoginId();
        this.password = encodePassword(passwordEncoder, request.getPassword());
        this.mobileNumber = request.getMobileNumber();
    }

    private String encodePassword(PasswordEncoder passwordEncoder, String password) {
        return passwordEncoder.encode(password);
    }
}
