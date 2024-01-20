package com.dyspersja.busscheduler.model.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BusLineDetailsDTO {
    private Long id;
    private int lineNumber;
    private boolean isReturnLine;
    private BusStopBriefDTO startBusStop;
    private BusStopBriefDTO endBusStop;
}
