package com.example.scheduler2.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {

    private final String title;

    private final String content;

    public CreateScheduleRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
