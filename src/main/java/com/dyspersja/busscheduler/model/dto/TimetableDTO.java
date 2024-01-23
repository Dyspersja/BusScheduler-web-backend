package com.dyspersja.busscheduler.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.sql.Time;
import java.util.List;

@Builder
@Getter
public class TimetableDTO {
    private List<Time> weekdays;
    private List<Time> saturdays;
    private List<Time> sundays;
}
