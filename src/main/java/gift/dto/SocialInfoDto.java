package gift.dto;

public class SocialInfoDto {

    private Long socialId;
    private String providerType;
    private String socialAccessToken;

    protected SocialInfoDto() {
    }

    public SocialInfoDto(Long socialId, String providerType, String socialAccessToken) {
        this.socialId = socialId;
        this.providerType = providerType;
        this.socialAccessToken = socialAccessToken;
    }

    public Long getSocialId() {
        return socialId;
    }

    public String getProviderType() {
        return providerType;
    }

    public String getSocialAccessToken() {
        return socialAccessToken;
    }
}
