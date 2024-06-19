package greenjangtanji.yeosuro.member.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberStatus {

    ACTIVE ("ACTIVE","활동 회원"),
    INACTIVE ("INACTIVE", "휴먼 회원");

    private final String key;
    private final String title;

}
