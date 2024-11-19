package com.example.scheduler2.dto;

import lombok.Getter;

@Getter
public class UpdateScheduleDto {

    private final String newContent;

    public UpdateScheduleDto(String newContent) {
        this.newContent = newContent;
    }

}
