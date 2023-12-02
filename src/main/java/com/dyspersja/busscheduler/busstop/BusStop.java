package com.dyspersja.busscheduler.busstop;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "bus_stops")
@Entity
public class BusStop {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "stop_name")
    private String name;

    @Column(name = "stop_number")
    private Integer number;

    @Column(name = "city_district_id")
    private Integer cityDistrictId;

    @Column(name = "street")
    private String street;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;
}
