package com.dyspersja.busscheduler.repository;

import com.dyspersja.busscheduler.model.dto.BusStopBriefDTO;
import com.dyspersja.busscheduler.model.entity.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BusStopRepository extends JpaRepository<BusStop, Long> {

    @Query("SELECT NEW com.dyspersja.busscheduler.model.dto.BusStopBriefDTO(" +
            "bs.id              AS id, " +
            "bs.stopName        AS stopName, " +
            "cd.districtName    AS cityDistrictName) " +

            "FROM BusStop bs " +

            "JOIN CityDistrict cd   ON bs.cityDistrict.id = cd.id " +
            "JOIN LineStop ls       ON bs.id = ls.busStop.id " +
            "JOIN BusLine bl        ON ls.busLine.id = bl.id " +

            "WHERE bl.lineNumber = :lineNumber AND bl.isReturnLine = :isReturn")
    List<BusStopBriefDTO> getBusStopsByLineNumberAndReturnLine(
            @Param("lineNumber") int lineNumber,
            @Param("isReturn") boolean isReturn
    );
}
