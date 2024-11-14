package com.example.scheduler2.dto;

import lombok.Getter;

@Getter
public class UpdateSchedule {

    private final String newContent;

    public UpdateSchedule(String newContent) {
        this.newContent = newContent;
    }

}
