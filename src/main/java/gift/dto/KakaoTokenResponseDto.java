package gift.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KakaoTokenResponseDto {

    @JsonProperty("token_type")
    String tokenType;
    @JsonProperty("access_token")
    String accessToken;
    @JsonProperty("id_token")
    String idToken;
    @JsonProperty("expires_in")
    Integer expiresIn;
    @JsonProperty("refresh_token")
    String refreshToken;
    @JsonProperty("refresh_token_expires_in")
    Integer refreshTokenExpiresIn;
    @JsonProperty("scope")
    String scope;

    public KakaoTokenResponseDto() {
    }

    public KakaoTokenResponseDto(String tokenType, String accessToken, String idToken,
        Integer expiresIn, String refreshToken, Integer refreshTokenExpiresIn, String scope) {
        this.tokenType = tokenType;
        this.accessToken = accessToken;
        this.idToken = idToken;
        this.expiresIn = expiresIn;
        this.refreshToken = refreshToken;
        this.refreshTokenExpiresIn = refreshTokenExpiresIn;
        this.scope = scope;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
