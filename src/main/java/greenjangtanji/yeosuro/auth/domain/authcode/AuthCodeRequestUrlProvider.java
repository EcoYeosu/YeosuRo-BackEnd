package greenjangtanji.yeosuro.auth.domain.authcode;

import greenjangtanji.yeosuro.auth.domain.OauthServerType;

//AuthCode를 발급할 URL을 제공하는 기능을 제공
public interface AuthCodeRequestUrlProvider {

    //자신이 어떤 OauthServerType를 지원할 수 있는지
    OauthServerType supportServer();

    //URL을 생성하여 반환
    String provide();
}
