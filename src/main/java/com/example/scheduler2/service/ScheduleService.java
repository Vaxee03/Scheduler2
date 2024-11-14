package com.example.scheduler2.service;

import com.example.scheduler2.dto.ScheduleResponseDto;
import com.example.scheduler2.entity.Member;
import com.example.scheduler2.entity.Schedule;
import com.example.scheduler2.repository.MemberRepository;
import com.example.scheduler2.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private ScheduleRepository scheduleRepository;
    private MemberRepository memberRepository;

    public ScheduleResponseDto save(Long id, String title, String content) {

        Member findmember = memberRepository.findMemberByIdOrElseThrowThrow(id);

        Schedule schedule = new Schedule(title, content);
        schedule.setMember(findmember);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(schedule.getId(),schedule.getTitle(),schedule.getContents());
    }

    public List<ScheduleResponseDto> findAll() {

        return scheduleRepository.findAll().stream().map(ScheduleResponseDto::toDto).toList();

    }

    public ScheduleResponseDto findById(Long id) {

        Schedule findschedule = scheduleRepository.findByIdOrElseThrow(id);

        return new ScheduleResponseDto(findschedule.getId(),findschedule.getTitle(),findschedule.getContents());
    }
}
