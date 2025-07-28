package gift.controller;

import gift.dto.KakaoUserInfoResponseDto;
import gift.dto.TokenResponse;
import gift.service.KakaoService;
import gift.service.MemberService;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KakaoLoginController {

    private final KakaoService kakaoService;
    private final MemberService memberService;

    public KakaoLoginController(KakaoService kakaoService, MemberService memberService) {
        this.kakaoService = kakaoService;
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<TokenResponse> callback(@RequestParam("code") String code) {
        String kakaoAccessToken = kakaoService.getAccessTokenFromKakao(code);

        KakaoUserInfoResponseDto userInfo = kakaoService.getUserInfo(kakaoAccessToken);
        Long kakaoId = userInfo.getId();

        if (!memberService.isKakaoIdExists(kakaoId)) {
            //회원가입
            URI redirectUri = URI.create("/admin/members/new?kakaoId=" + kakaoId);
            return ResponseEntity.status(HttpStatus.FOUND).location(redirectUri).build();
        }

        //로그인
        TokenResponse accessToken = memberService.findByKakaoId(kakaoId);

        return ResponseEntity.status(HttpStatus.OK).body(accessToken);
    }


}
