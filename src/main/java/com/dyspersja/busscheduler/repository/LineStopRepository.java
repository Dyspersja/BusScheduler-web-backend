package com.dyspersja.busscheduler.repository;

import com.dyspersja.busscheduler.model.entity.LineStop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LineStopRepository extends JpaRepository<LineStop, Long> {

    @Query("SELECT ls.travelTime " +
            "FROM LineStop ls " +
            "WHERE ls.busLine.id = :busLineId " +
            "    AND ls.busStop.id = :busStopId")
    int getTravelTimeByBusLineIdAndBusStopId(
            @Param("busLineId") Long busLineId,
            @Param("busStopId") Long busStopId
    );
}
