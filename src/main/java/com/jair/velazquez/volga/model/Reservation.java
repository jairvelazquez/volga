package com.jair.velazquez.volga.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    private Long id;

    private Long residentId;
    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isPrivateEvent;
    private Long statusId;


}
