package com.dyspersja.busscheduler.busstop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BusStopService {

    private final BusStopRepository repository;

    public List<BusStop> getBusStops() {
        return repository.findAll();
    }

    public BusStop getBusStop(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new BusStopNotFoundException(id));
    }
}
