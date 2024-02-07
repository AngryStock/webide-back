package king.ide.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import king.ide.controller.request.SignupRequest;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter
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

    public static boolean matchPassword(PasswordEncoder passwordEncoder, String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
