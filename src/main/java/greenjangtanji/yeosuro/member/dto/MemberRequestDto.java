package greenjangtanji.yeosuro.member.dto;

import greenjangtanji.yeosuro.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberRequestDto {
    @Getter
    @NoArgsConstructor
    public static class Post {
        private String email;
        private String username;
        private String password;
        private String agree;
    }

    @Getter
    @NoArgsConstructor
    public static class Patch {
        private String username;
        private String userImageUrl;
    }
}
