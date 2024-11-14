package com.example.scheduler2.dto;

import com.example.scheduler2.entity.Schedule;
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

    public static ScheduleResponseDto toDto(Schedule schedule) {

        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getContents());

    }
}
