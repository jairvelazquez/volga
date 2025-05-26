package com.jair.velazquez.volga.controller;

import com.jair.velazquez.volga.model.Reservation;
import com.jair.velazquez.volga.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private ReservationService reservationService;


    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @GetMapping
    public Flux<Reservation> getAllReservations() {
        return reservationService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Reservation>> getReservationById(@PathVariable Long id) {
        return reservationService.findById(id)
                .map(reservation -> ResponseEntity.ok(reservation))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<Reservation>> createReservation(@RequestBody Reservation reservation) {
        return reservationService.save(reservation)
                .map(savedReservation -> ResponseEntity.status(HttpStatus.CREATED).body(savedReservation));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteReservation(@PathVariable Long id) {
        return reservationService.deleteById(id)
                .then(Mono.just(ResponseEntity.noContent().build()));
    }
}
