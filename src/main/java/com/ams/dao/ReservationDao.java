package com.ams.dao;

import java.util.List;


import com.ams.entity.Reservation;

public interface ReservationDao {
	
	//Reservation
    Reservation createReservation(Reservation reservation);
    Reservation getReservationById(String reservationId);
    void updateReservation(Reservation reservation);
    List<Reservation> getAllReservations();
    void deleteReservation(String reservationId);

}
