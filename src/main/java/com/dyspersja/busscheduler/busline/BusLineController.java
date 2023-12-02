package com.dyspersja.busscheduler.busline;

import com.dyspersja.busscheduler.busstop.BusStop;
import com.dyspersja.busscheduler.busstop.BusStopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/bus_lines")
public class BusLineController {

    private final BusLineService service;

    @GetMapping
    public List<BusLine> getBusLines() {
        return service.getBusLines();
    }

    @GetMapping("/{id}")
    public BusLine getBusLine(@PathVariable int id) {
        return service.getBusLine(id);
    }
}
