package com.dyspersja.busscheduler.repository;

import com.dyspersja.busscheduler.model.entity.OperatingDay;
import com.dyspersja.busscheduler.model.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    @Query("SELECT r.departureTime " +
            "FROM Route r " +
            "WHERE r.busLine.id = :busLineId " +
            "    AND r.operatingDay = :operatingDay")
    List<Time> getDepartureTimesByLineAndOperatingDay(
            @Param("busLineId") Long busLineId,
            @Param("operatingDay") OperatingDay operatingDay
    );
}
