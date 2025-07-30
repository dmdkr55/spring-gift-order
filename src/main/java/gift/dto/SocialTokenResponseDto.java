package gift.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SocialTokenResponseDto {

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

    public SocialTokenResponseDto() {
    }

    public SocialTokenResponseDto(String tokenType, String accessToken, String idToken,
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

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
