package gift.service;

import gift.config.KakaoProperties;
import gift.dto.KakaoTokenResponseDto;
import java.net.URI;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class KakaoService {

    KakaoProperties properties;
    RestTemplate restTemplate;

    public KakaoService(KakaoProperties properties, RestTemplate restTemplate) {
        this.properties = properties;
        this.restTemplate = restTemplate;
    }

    public String getAccessTokenFromKakao(String authorizationCode) {

        var url = "https://kauth.kakao.com/oauth/token";
        var headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        var body = new LinkedMultiValueMap<String, String>();
        body.add("grant_type", "authorization_code");
        body.add("client_id", properties.clientId());
        body.add("redirect_uri", properties.redirectUri());
        body.add("code", authorizationCode);
        var request = new RequestEntity<>(body, headers, HttpMethod.POST, URI.create(url));

        KakaoTokenResponseDto responseDto = restTemplate.postForEntity(url, request,
            KakaoTokenResponseDto.class).getBody();

        return responseDto.getAccessToken();
    }

}
