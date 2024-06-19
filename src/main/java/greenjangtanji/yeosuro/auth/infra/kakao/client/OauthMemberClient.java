package greenjangtanji.yeosuro.auth.infra.kakao.client;

import greenjangtanji.yeosuro.auth.domain.OauthMember;
import greenjangtanji.yeosuro.auth.domain.OauthServerType;

public interface OauthMemberClient {
    OauthServerType supportServer();

    OauthMember fetch(String code);
}
