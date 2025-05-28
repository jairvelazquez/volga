package com.jair.velazquez.volga.utils.constants;

public class ReservationRepositoryQueries {

    public static final String FIND_BY_USER_ID = "SELECT * FROM reservations WHERE user_id = :userId";
    public static final String FIND_BY_DATE = "SELECT * FROM reservations WHERE date = :date";
    public static final String COUNT_PRIVATE_RESERVATIONS_BY_USER_IN_YEAR = " SELECT COUNT(*) FROM reservations\n" +
            "        WHERE user_id = :userId\n" +
            "        AND EXTRACT(YEAR FROM date) = :year";
    public static final String FIND_RESERVATIONS_NEXT_MONTH = " SELECT * FROM reservations\n" +
            "        WHERE :date >= current_date \n AND :date <= current_date + 30" +
            "        AND (\n" +
            "            (start_time <= :endTime AND end_time >= :startTime)\n" +
            "        )";

}
