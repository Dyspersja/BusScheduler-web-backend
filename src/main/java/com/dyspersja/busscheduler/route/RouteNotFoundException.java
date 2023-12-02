package com.dyspersja.busscheduler.route;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RouteNotFoundException extends RuntimeException {
    public RouteNotFoundException(int id) {
        super(String.format("Route with id: '%d' not found.", id));
    }
}
