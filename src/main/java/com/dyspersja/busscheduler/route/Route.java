package com.dyspersja.busscheduler.route;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "routes")
@Entity
public class Route {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "bus_line_id")
    private Integer busLineId;

    @Column(name = "departure_time")
    private Time departureTime;

    @Column(name = "operating_day")
    private OperatingDay operatingDay;
}
