package gift.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import gift.model.Member;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        memberRepository.deleteAll(); // 테스트마다 DB 초기화
    }

    @Test
    void save() {
        // given
        Member expected = new Member("kim@naver.com", "1234", -1L);

        // when
        Member actual = memberRepository.save(expected);

        // then
        assertAll(
            () -> assertThat(actual.getId()).isNotNull(),
            () -> assertThat(actual.getEmail()).isEqualTo(expected.getEmail()),
            () -> assertThat(actual.getPassword()).isEqualTo(expected.getPassword())
        );
    }

    @Test
    void findByEmail() {
        // given
        Member expected = new Member("kim@naver.com", "1234", -1L);
        memberRepository.save(expected);

        // when
        Member actual = memberRepository.findByEmail(expected.getEmail()).get();

        // then
        assertThat(actual.getEmail()).isEqualTo(expected.getEmail());
    }

    @Test
    void findAll() {
        // given
        Member member1 = new Member("kim@naver.com", "1234", -1L);
        Member member2 = new Member("lee@naver.com", "5678", -1L);
        memberRepository.save(member1);
        memberRepository.save(member2);

        // when
        List<Member> members = memberRepository.findAll();

        // then
        assertAll(
            () -> assertThat(members).hasSize(2),
            () -> assertThat(members)
                .extracting(Member::getEmail)
                .containsExactlyInAnyOrder("kim@naver.com", "lee@naver.com")
        );
    }
}
