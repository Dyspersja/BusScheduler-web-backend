package com.dyspersja.busscheduler.repository;

import com.dyspersja.busscheduler.model.dto.BusLineDetailsDTO;
import com.dyspersja.busscheduler.model.entity.BusLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BusLineRepository extends JpaRepository<BusLine, Long> {
    
    @Query("SELECT NEW com.dyspersja.busscheduler.model.dto.BusLineDetailsDTO(" +
            "bl.id              AS id, " +
            "bl.lineNumber      AS lineNumber, " +
            "bl.isReturnLine    AS isReturnLine, " +

            "NEW com.dyspersja.busscheduler.model.dto.BusStopBriefDTO(" +
            "startStop.id                           AS startBusStopId, " +
            "startStop.stopName                     AS startBusStopName, " +
            "startStop.cityDistrict.districtName    AS startCityDistrictName), " +

            "NEW com.dyspersja.busscheduler.model.dto.BusStopBriefDTO(" +
            "endStop.id                             AS endBusStopId, " +
            "endStop.stopName                       AS endBusStopName, " +
            "endStop.cityDistrict.districtName      AS endCityDistrictName)) " +

            "FROM BusLine bl " +

            "JOIN LineStop start    ON bl.id = start.busLine.id AND start.isStart = true " +
            "JOIN BusStop startStop ON start.busStop.id = startStop.id " +
            "JOIN LineStop end      ON bl.id = end.busLine.id AND end.isEnd = true " +
            "JOIN BusStop endStop   ON end.busStop.id = endStop.id")
    List<BusLineDetailsDTO> getDetailedBusLines();
}
