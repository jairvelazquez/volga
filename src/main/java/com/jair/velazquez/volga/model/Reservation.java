package com.jair.velazquez.volga.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reservation {

    @Id
    private Long id;
    private Long userId;
    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long statusId;

}
