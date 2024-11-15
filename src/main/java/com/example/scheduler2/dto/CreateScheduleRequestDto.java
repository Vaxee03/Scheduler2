package com.example.scheduler2.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {

    private final Long memberId;

    private final String title;

    private final String content;


    public CreateScheduleRequestDto(Long memberId, String title, String content) {
        this.memberId = memberId;
        this.title = title;
        this.content = content;

    }
}
