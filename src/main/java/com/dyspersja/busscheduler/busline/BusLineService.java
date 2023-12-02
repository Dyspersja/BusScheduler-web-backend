package com.dyspersja.busscheduler.busline;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BusLineService {

    private final BusLineRepository repository;

    public List<BusLine> getBusLines() {
        return repository.findAll();
    }

    public BusLine getBusLine(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new BusLineNotFoundException(id));
    }
}
