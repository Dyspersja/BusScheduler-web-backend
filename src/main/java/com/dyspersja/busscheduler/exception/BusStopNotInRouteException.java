package com.dyspersja.busscheduler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BusStopNotInRouteException extends RuntimeException {

    public BusStopNotInRouteException(Long busLineId, Long busStopId) {
        super("Bus stop with ID " + busStopId + " is not on the line with ID " + busLineId);
    }
}
