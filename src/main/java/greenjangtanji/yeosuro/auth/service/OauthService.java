package greenjangtanji.yeosuro.auth.service;

import greenjangtanji.yeosuro.auth.domain.OauthMember;
import greenjangtanji.yeosuro.auth.domain.OauthMemberRepository;
import greenjangtanji.yeosuro.auth.domain.OauthServerType;
import greenjangtanji.yeosuro.auth.domain.authcode.AuthCodeRequestUrlProviderComposite;
import greenjangtanji.yeosuro.auth.infra.kakao.client.OauthMemberClientComposite;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OauthService {

    private final AuthCodeRequestUrlProviderComposite authCodeRequestUrlProviderComposite;
    private final OauthMemberClientComposite oauthMemberClientComposite;
    private final OauthMemberRepository oauthMemberRepository;

    public String getAuthCodeRequestUrl(OauthServerType oauthServerType) {
        return authCodeRequestUrlProviderComposite.provide(oauthServerType);
    }

    public Long login(OauthServerType oauthServerType, String authCode) {

        OauthMember oauthMember = oauthMemberClientComposite.fetch(oauthServerType, authCode);
        OauthMember saved = oauthMemberRepository.findByOauthId(oauthMember.oauthId())
                .orElseGet(() -> oauthMemberRepository.save(oauthMember));
        return saved.id();
    }
}

