package greenjangtanji.yeosuro.member.service;

import greenjangtanji.yeosuro.member.dto.MemberRequestDto;
import greenjangtanji.yeosuro.member.entity.Member;
import greenjangtanji.yeosuro.member.entity.MemberAuthorize;
import greenjangtanji.yeosuro.member.entity.MemberStatus;
import greenjangtanji.yeosuro.member.repostory.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member createUser(MemberRequestDto.Post postDto) {
       Member member = Member.createMember(postDto);

        return memberRepository.save(member);
    }
}
