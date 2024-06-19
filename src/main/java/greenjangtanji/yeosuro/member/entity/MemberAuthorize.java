package greenjangtanji.yeosuro.member.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberAuthorize {
    MANAGER("ROLE_MANAGER", "관리자"),
    USER("ROLE_USER","일반 사용자");

    private final String key;
    private final String title;
}
