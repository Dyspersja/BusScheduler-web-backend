package com.dyspersja.busscheduler.model.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BusStopBriefDTO {
    private Long id;
    private String stopName;
    private String cityDistrictName;
}
