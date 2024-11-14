package com.example.scheduler2.service;

import com.example.scheduler2.repository.MemberRepository;
import com.example.scheduler2.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private ScheduleRepository scheduleRepository;
    private MemberRepository memberRepository;
}
