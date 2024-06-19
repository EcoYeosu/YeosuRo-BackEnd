package greenjangtanji.yeosuro.member.service;

import greenjangtanji.yeosuro.member.dto.MemberRequestDto;
import greenjangtanji.yeosuro.member.entity.Member;
import greenjangtanji.yeosuro.member.repostory.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member createUser(MemberRequestDto.Post postDto) {
        Member user = new Member();
        user.setUsername(postDto.getUsername());
        user.setPassword(postDto.getPassword());

        return memberRepository.save(user);
    }
}
