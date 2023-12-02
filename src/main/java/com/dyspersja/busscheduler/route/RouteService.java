package com.dyspersja.busscheduler.route;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RouteService {

    private final RouteRepository repository;

    public List<Route> getRoutes() {
        return repository.findAll();
    }

    public Route getRoute(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RouteNotFoundException(id));
    }
}
