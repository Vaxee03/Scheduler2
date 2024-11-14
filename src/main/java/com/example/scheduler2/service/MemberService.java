package com.example.scheduler2.service;

import com.example.scheduler2.dto.SignupResponseDto;
import com.example.scheduler2.entity.Member;
import com.example.scheduler2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public SignupResponseDto signup(String username, String password, String email) {

        Member member = new Member(username, password, email);

        Member savedMember = memberRepository.save(member);

        return new SignupResponseDto(savedMember.getId(), savedMember.getUsername(), savedMember.getEmail());
    }
}
