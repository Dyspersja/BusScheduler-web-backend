package com.dyspersja.busscheduler.busline;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BusLineNotFoundException extends RuntimeException {
    public BusLineNotFoundException(int id) {
        super(String.format("Bus line with id: '%d' not found.", id));
    }
}
