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

    @Column(name = "kakao_id", nullable = false)
    private Long kakaoId;


    public Member() {

    }

    public Member(Long id, String email, String password, Long kakaoId) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.kakaoId = kakaoId;
    }

    public Member(String email, String password, Long kakaoId) {
        this(null, email, password, kakaoId);
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

    public Long getKakaoId() {
        return kakaoId;
    }
}
