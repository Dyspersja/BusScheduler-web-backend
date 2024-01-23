package com.dyspersja.busscheduler.repository;

import com.dyspersja.busscheduler.model.entity.LineStop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LineStopRepository extends JpaRepository<LineStop, Long> {

    @Query("SELECT ls.travelTime " +
            "FROM LineStop ls " +
            "WHERE ls.busLine.id = :busLineId " +
            "    AND ls.busStop.id = :busStopId")
    Optional<Integer> getTravelTimeByBusLineIdAndBusStopId(
            @Param("busLineId") Long busLineId,
            @Param("busStopId") Long busStopId
    );
}
