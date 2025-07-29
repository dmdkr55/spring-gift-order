package gift.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "social_id")
    private Long socialId;

    @Column(name = "provider_type")
    private String providerType;

    @Column(name = "social_access_token")
    private String socialAccessToken;

    public Member() {
    }

    public Member(String email, String password) {
        this(null, email, password, -1L, null, null);
    }

    public Member(String email, String password, Long socialId, String providerType,
        String socialAccessToken) {
        this(null, email, password, socialId, providerType, socialAccessToken);
    }

    public Member(Long id, String email, String password, Long socialId, String providerType,
        String socialAccessToken) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.socialId = socialId;
        this.providerType = providerType;
        this.socialAccessToken = socialAccessToken;
    }

    public void updateSocialInfo(Long socialId, String providerType, String socialAccessToken) {
        this.socialId = socialId;
        this.providerType = providerType;
        this.socialAccessToken = socialAccessToken;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
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
