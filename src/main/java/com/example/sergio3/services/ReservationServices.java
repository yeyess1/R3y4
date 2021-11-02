package com.example.sergio3.services;

import com.example.sergio3.crud.ReservationRepository;
import com.example.sergio3.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServices {
    @Autowired
    private ReservationRepository ReservationCrudRepository;

    public List<Reservation> getAll(){
        return ReservationCrudRepository.getAll();
    }

    public Optional<Reservation> getReservation (int reservationId) {
        return ReservationCrudRepository.getReservation(reservationId);
    }

    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return ReservationCrudRepository.save(reservation);
        }else{
            Optional<Reservation> e= ReservationCrudRepository.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return ReservationCrudRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= ReservationCrudRepository.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                ReservationCrudRepository.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            ReservationCrudRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}

