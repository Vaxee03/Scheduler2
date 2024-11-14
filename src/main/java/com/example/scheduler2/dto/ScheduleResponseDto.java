package com.example.scheduler2.dto;

import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private final long id;

    private final String title;

    private final String content;

    public ScheduleResponseDto(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
