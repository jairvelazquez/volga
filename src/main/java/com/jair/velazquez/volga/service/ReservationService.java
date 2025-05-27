package com.jair.velazquez.volga.service;


import com.jair.velazquez.volga.model.Reservation;
import com.jair.velazquez.volga.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Mono<Reservation> createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Flux<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Mono<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public Mono<Reservation> updateReservation(Long id, Reservation updatedReservation) {
        return reservationRepository.findById(id)
                .flatMap(existing -> {
                    existing.setDate(updatedReservation.getDate());
                    existing.setStartTime(updatedReservation.getStartTime());
                    existing.setEndTime(updatedReservation.getEndTime());
                    existing.setUserId(updatedReservation.getUserId());
                    existing.setStatusId(updatedReservation.getStatusId());
                    return reservationRepository.save(existing);
                });
    }

    public Mono<Void> deleteReservation(Long id) {
        return reservationRepository.deleteById(id);
    }

    public Flux<Reservation> getReservationsByDate(String date) {
        return reservationRepository.findByDate(date);
    }

    public Mono<Long> countPrivateReservationsInYear(Long userId, int year) {
        return reservationRepository.countPrivateReservationsByUserInYear(userId, year);
    }
}