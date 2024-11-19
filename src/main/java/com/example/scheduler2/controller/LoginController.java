package com.example.scheduler2.controller;

import com.example.scheduler2.dto.LoginRequestDto;
import com.example.scheduler2.entity.Member;
import com.example.scheduler2.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class LoginController {

    private final MemberRepository memberRepository;

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest request) {

        Optional<Member> findMemberByEmail = memberRepository.findMemberByEmail(loginRequestDto.getEmail());

        if (findMemberByEmail.isEmpty()) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        Member member = findMemberByEmail.get();

        if (!Objects.equals(member.getPassword(), loginRequestDto.getPassword())) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("sessionKey", member.getEmail());

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
            return new ResponseEntity(HttpStatus.OK);
        }

        else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
