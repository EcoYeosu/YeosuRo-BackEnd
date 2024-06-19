package greenjangtanji.yeosuro.auth.infra.kakao;

import greenjangtanji.yeosuro.auth.domain.OauthMember;
import greenjangtanji.yeosuro.auth.domain.OauthServerType;
import greenjangtanji.yeosuro.auth.infra.kakao.client.KakaoApiClient;
import greenjangtanji.yeosuro.auth.infra.kakao.client.OauthMemberClient;
import greenjangtanji.yeosuro.auth.infra.kakao.dto.KakaoMemberResponse;
import greenjangtanji.yeosuro.auth.infra.kakao.dto.KakaoToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Component
@RequiredArgsConstructor
public class KakaoMemberClient implements OauthMemberClient {

    private final KakaoApiClient kakaoApiClient;
    private final KakaoOauthConfig kakaoOauthConfig;

    @Override
    public OauthServerType supportServer() {
        return OauthServerType.KAKAO;
    }

    @Override
    public OauthMember fetch(String authCode) {
        KakaoToken tokenInfo = kakaoApiClient.fetchToken(tokenRequestParams(authCode)); // (1) Auth Code를 통해서 AccessToken을 조회
        KakaoMemberResponse kakaoMemberResponse =
                kakaoApiClient.fetchMember("Bearer " + tokenInfo.accessToken());  // (2)AccessToken을 가지고 회원 정보를 받아옴
        return kakaoMemberResponse.toDomain();  // (3)회원 정보를 OauthMember 객체로 변환
    }

    private MultiValueMap<String, String> tokenRequestParams(String authCode) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", kakaoOauthConfig.clientId());
        params.add("redirect_uri", kakaoOauthConfig.redirectUri());
        params.add("code", authCode);
        params.add("client_secret", kakaoOauthConfig.clientSecret());
        return params;
    }
}