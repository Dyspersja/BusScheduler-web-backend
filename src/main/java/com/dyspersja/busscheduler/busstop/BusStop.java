package com.dyspersja.busscheduler.busstop;

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
    private Integer id;
    private Integer number;
    private String city;
    private String street;
    private Double latitude;
    private Double longitude;
}
