package com.dyspersja.busscheduler.busline;

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
@Table(name = "bus_lines")
@Entity
public class BusLine {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "line_number")
    private Integer number;

    @Column(name = "is_return_line")
    private Boolean isReturnLine;
}
