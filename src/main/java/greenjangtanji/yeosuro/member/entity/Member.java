package greenjangtanji.yeosuro.member.entity;

import greenjangtanji.yeosuro.feed.entity.Feed;
import greenjangtanji.yeosuro.member.dto.MemberRequestDto;
import greenjangtanji.yeosuro.reply.entity.Reply;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @Column(nullable = false)
    private String username;

    private String password;

    private LocalDateTime lastLoginDate;

    private String agree;

    private String userImageUrl;

    @Enumerated(EnumType.STRING)
    private MemberAuthorize authorize;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;


    @OneToMany(mappedBy = "member", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Feed> feeds = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Reply> replies = new ArrayList<>();



    public static Member createMember (MemberRequestDto.Post requestDto){
        Member member = new Member();
        member.email = requestDto.getEmail();
        member.username = requestDto.getUsername();
        member.password = requestDto.getPassword();
        member.agree = requestDto.getAgree();
        member.status = MemberStatus.ACTIVE;
        member.authorize = MemberAuthorize.USER;
        return member;
    }

    public void updateMember (String username, String userImageUrl){
        this.username = username;
        this.userImageUrl = userImageUrl;
    }
}
