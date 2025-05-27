package com.jair.velazquez.volga.repository;

import com.jair.velazquez.volga.model.Reservation;
import com.jair.velazquez.volga.utils.constants.ReservationRepositoryQueries;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReservationRepository extends ReactiveCrudRepository<Reservation, Long> {

    @Query(ReservationRepositoryQueries.FIND_BY_USER_ID)
    Flux<Reservation> findByUserId(Long userId);

    @Query(ReservationRepositoryQueries.FIND_BY_DATE)
    Flux<Reservation> findByDate(String date);

    @Query(ReservationRepositoryQueries.COUNT_PRIVATE_RESERVATIONS_BY_USER_IN_YEAR)
    Mono<Long> countPrivateReservationsByUserInYear(Long userId, int year);

    @Query(ReservationRepositoryQueries.FIND_RESERVATIONS_NEXT_MONTH)
    Flux<Reservation> findNextReservations(String date);

}
