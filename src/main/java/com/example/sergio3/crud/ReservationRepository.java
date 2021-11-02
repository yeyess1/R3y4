package com.example.sergio3.crud;


import com.example.sergio3.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){ return (List<Reservation>) reservationCrudRepository.findAll();}
    public Optional<Reservation> getReservation (int ID){
        return reservationCrudRepository.findById(ID);
    }
    public Reservation save (Reservation reservation){return reservationCrudRepository.save(reservation);}
    public void delete (Reservation reservation){reservationCrudRepository.delete(reservation);}

}
