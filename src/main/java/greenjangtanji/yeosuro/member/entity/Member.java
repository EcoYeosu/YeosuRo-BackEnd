package greenjangtanji.yeosuro.member.entity;

import greenjangtanji.yeosuro.feed.entity.Feed;
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
@Setter
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


    @Builder
    public Member (Long id,String email, String username, String password, String agree){
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.agree = agree;
    }

    public void updateMember (String username, String userImageUrl){
        this.username = username;
        this.userImageUrl = userImageUrl;
    }
}
