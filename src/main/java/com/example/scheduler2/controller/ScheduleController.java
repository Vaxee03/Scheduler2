package com.example.scheduler2.controller;

import com.example.scheduler2.dto.CreateScheduleRequestDto;
import com.example.scheduler2.dto.ScheduleResponseDto;
import com.example.scheduler2.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody CreateScheduleRequestDto requestDto){

        ScheduleResponseDto scheduleResponseDto = scheduleService.save(requestDto.getId(), requestDto.getTitle(), requestDto.getContent());

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }


}
