package greenjangtanji.yeosuro.member.controller;

import greenjangtanji.yeosuro.member.dto.MemberRequestDto;
import greenjangtanji.yeosuro.member.entity.Member;
import greenjangtanji.yeosuro.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody MemberRequestDto.Post postDto) {

        Member member = memberService.createUser(postDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
