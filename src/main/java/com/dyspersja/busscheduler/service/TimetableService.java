package com.dyspersja.busscheduler.service;

import com.dyspersja.busscheduler.Exception.BusStopNotInRouteException;
import com.dyspersja.busscheduler.model.dto.TimetableDTO;
import com.dyspersja.busscheduler.model.entity.OperatingDay;
import com.dyspersja.busscheduler.repository.LineStopRepository;
import com.dyspersja.busscheduler.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimetableService {

    private final RouteRepository routeRepository;
    private final LineStopRepository lineStopRepository;

    public TimetableDTO getTimetableByLineAndBusStop(Long busLineId, Long busStopId) {
        List<Time> weekdays = routeRepository.getDepartureTimesByLineAndOperatingDay(
                busLineId, OperatingDay.WEEKDAYS);
        List<Time> saturdays = routeRepository.getDepartureTimesByLineAndOperatingDay(
                busLineId, OperatingDay.SATURDAYS);
        List<Time> sundays = routeRepository.getDepartureTimesByLineAndOperatingDay(
                busLineId, OperatingDay.SUNDAYS);

        int timeDelay = lineStopRepository
                .getTravelTimeByBusLineIdAndBusStopId(busLineId, busStopId)
                .orElseThrow(() -> new BusStopNotInRouteException(busLineId, busStopId));

        return TimetableDTO.builder()
                .weekdays(plusMinutes(weekdays,timeDelay))
                .saturdays(plusMinutes(saturdays,timeDelay))
                .sundays(plusMinutes(sundays,timeDelay))
                .build();
    }

    private List<Time> plusMinutes(List<Time> timeList, int travelTime) {
        return timeList.stream().map(time -> Time.valueOf(time.toLocalTime().plusMinutes(travelTime))).toList();
    }
}
