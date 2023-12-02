package com.dyspersja.busscheduler.route;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/routes")
public class RouteController {

    private final RouteService service;

    @GetMapping
    public List<Route> getRoutes() {
        return service.getRoutes();
    }

    @GetMapping("/{id}")
    public Route getRoute(@PathVariable int id) {
        return service.getRoute(id);
    }
}
