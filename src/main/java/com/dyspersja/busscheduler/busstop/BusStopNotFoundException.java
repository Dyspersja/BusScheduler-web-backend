package com.dyspersja.busscheduler.busstop;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BusStopNotFoundException extends RuntimeException {
    public BusStopNotFoundException(int id) {
        super(String.format("Bus stop with id: '%d' not found.", id));
    }
}
