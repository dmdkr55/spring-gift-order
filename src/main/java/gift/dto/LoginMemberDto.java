package gift.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginMemberDto {

    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "유효한 이메일 형식이 아닙니다.")
    private String email;

    private String jwtAccessToken;

    protected LoginMemberDto() {
    }

    public LoginMemberDto(String email) {
        this.email = email;
    }

    public LoginMemberDto(String email, String jwtAccessToken) {
        this.email = email;
        this.jwtAccessToken = jwtAccessToken;
    }

    public String getEmail() {
        return email;
    }

    public String getJwtAccessToken() {
        return jwtAccessToken;
    }

}
