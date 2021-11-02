package com.example.sergio3.crud;

import com.example.sergio3.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository <Reservation, Integer>{
}
