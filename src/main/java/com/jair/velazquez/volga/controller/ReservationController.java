package com.jair.velazquez.volga.controller;

import com.jair.velazquez.volga.model.Reservation;
import com.jair.velazquez.volga.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public Mono<ResponseEntity<Reservation>> createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation)
                .map(savedReservation -> ResponseEntity.status(HttpStatus.CREATED).body(savedReservation));
    }

    @GetMapping
    public Flux<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Reservation>> getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteReservation(@PathVariable Long id) {
        return reservationService.deleteReservation(id)
                .then(Mono.just(ResponseEntity.noContent().build()));
    }
}
