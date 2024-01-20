package com.dyspersja.busscheduler.service;

import com.dyspersja.busscheduler.model.dto.BusLineDetailsDTO;
import com.dyspersja.busscheduler.model.dto.BusStopBriefDTO;
import com.dyspersja.busscheduler.repository.BusStopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusStopService {

    private final BusStopRepository repository;

    public List<BusStopBriefDTO> getBusStopsByLineNumberAndReturnLine(int lineNumber, boolean isReturn) {
        return repository.getBusStopsByLineNumberAndReturnLine(lineNumber, isReturn);
    }
}
