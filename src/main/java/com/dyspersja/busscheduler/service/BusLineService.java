package com.dyspersja.busscheduler.service;

import com.dyspersja.busscheduler.model.dto.BusLineDetailsDTO;
import com.dyspersja.busscheduler.repository.BusLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusLineService {

    private final BusLineRepository repository;

    public List<BusLineDetailsDTO> getDetailedBusLines() {
        return repository.getDetailedBusLines();
    }
}
